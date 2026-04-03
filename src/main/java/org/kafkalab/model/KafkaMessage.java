package org.kafkalab.model;

import lombok.Data;

/**
 * API/producer payload model for demo Kafka messages.
 */
@Data
public class KafkaMessage {
    private String data;
}
