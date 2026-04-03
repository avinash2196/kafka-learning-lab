package org.kafkalab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Kafka Patterns Learning Lab application.
 */
@SpringBootApplication
public class KafkaPatternsLearningLabApplication {

    /**
     * Boots the Spring context and starts the web application.
     *
     * @param args startup arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(KafkaPatternsLearningLabApplication.class, args);
    }
}