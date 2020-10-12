package com.twitter.producer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.UUID;

/**
 * The type Kafka producer.
 * @author fabrice
 */
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Send.
     *
     * @param topic   the topic
     * @param payload the payload
     */
    public void send(String topic, String payload) {
        String key = UUID.randomUUID().toString();
        log.info("***** Started send message with key = '{}' to topic = '{}'", key, topic);
        kafkaTemplate.send(topic, key , payload);
        log.info("***** Completed sending payload='{}' to kafka topic='{}'", payload, topic);
    }
}
