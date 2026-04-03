package org.kafkalab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * JPA entity used to persist Kafka payloads in the in-memory H2 database.
 */
@Entity
@Setter
@Getter
public class KafkaMessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Message value mirrored from Kafka payload. */
    private String data;
}
