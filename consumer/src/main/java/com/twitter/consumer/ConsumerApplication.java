package com.twitter.consumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Consumer application.
 * @author fabrice
 */
@SpringBootApplication
public class ConsumerApplication implements CommandLineRunner {

    private final SparkConsumerService sparkConsumerService;

    /**
     * Instantiates a new Consumer application.
     *
     * @param sparkConsumerService the spark consumer service
     */
    public ConsumerApplication(SparkConsumerService sparkConsumerService) {
        this.sparkConsumerService = sparkConsumerService;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sparkConsumerService.run();
    }
}
