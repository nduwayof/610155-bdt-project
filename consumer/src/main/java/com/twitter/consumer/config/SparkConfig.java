package com.twitter.consumer.config;

import org.apache.spark.SparkConf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Spark config.
 * @author fabrice
 */
@Configuration
public class SparkConfig {

    /**
     * Spark conf spark conf.
     *
     * @return the spark conf
     */
    @Bean
    public SparkConf sparkConf() {
        return new SparkConf()
                .setAppName("twitterKafkaWordCount")
                .setMaster("local[2]")
                .set("spark.executor.memory","1g");
    }
}
