package com.twitter.consumer;

import com.twitter.consumer.config.KafkaConsumerConfig;
import com.twitter.consumer.config.KafkaProperties;
import com.twitter.consumer.util.HashTagsUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import java.util.Collection;
import java.util.Collections;

/**
 * The type Spark consumer service.
 * @author fabrice
 */
@Slf4j
@Service
public class SparkConsumerService {

    private final SparkConf sparkConf;

    private final KafkaConsumerConfig kafkaConsumerConfig;

    private final KafkaProperties kafkaProperties;

    private final Collection<String> topics;

    public SparkConsumerService(SparkConf sparkConf, KafkaConsumerConfig kafkaConsumerConfig, KafkaProperties kafkaProperties) {
        this.sparkConf = sparkConf;
        this.kafkaConsumerConfig = kafkaConsumerConfig;
        this.kafkaProperties = kafkaProperties;
        this.topics = Collections.singletonList(kafkaProperties.getTemplate().getDefaultTopic());
    }

    /**
     * Run.
     */
    public void run() {

        log.info("***** Started running the spark consumer config.....");
        JavaStreamingContext javaStreamingContext = new JavaStreamingContext(sparkConf, Durations.seconds(10));
        JavaInputDStream<ConsumerRecord<String, String>> messages = KafkaUtils.createDirectStream(
                javaStreamingContext,
                LocationStrategies.PreferConsistent(),
                ConsumerStrategies.Subscribe(topics, kafkaConsumerConfig.consumerConfigs()));

        JavaDStream<String> lines = messages.map(ConsumerRecord::value);

        lines.count()
             .map(cnt -> "Popular hash tags in last 60 seconds (" + cnt + " total tweets):")
             .print();

        lines.flatMap(HashTagsUtils::hashTagsFromTweet)
             .mapToPair(hashTag -> new Tuple2<>(hashTag, 1))
             .reduceByKey(Integer::sum)
             .mapToPair(Tuple2::swap)
                .foreachRDD(rrdd -> {
                    log.info("---------------------------------------------------------------");

                    rrdd.sortByKey(false).collect()
                            .forEach(record -> {
                                log.info(String.format(" %s (%d)", record._2, record._1));
                    });
                });
        javaStreamingContext.start();
        try {
            javaStreamingContext.awaitTermination();
        } catch (InterruptedException e) {
            log.info("!!!!! Interrupted: {}",e);
        }
    }
}
