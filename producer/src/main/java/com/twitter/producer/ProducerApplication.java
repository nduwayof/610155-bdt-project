package com.twitter.producer;

import com.twitter.producer.service.TwitterStreamingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Producer application.
 * @author fabrice
 */
@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class ProducerApplication implements CommandLineRunner {

    private final TwitterStreamingService twitterStreamingService;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... strings) {
        log.info("Running Twitter Streaming ...");
        twitterStreamingService.stream();
    }
}
