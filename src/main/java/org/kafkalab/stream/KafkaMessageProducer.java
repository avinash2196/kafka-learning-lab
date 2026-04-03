package org.kafkalab.stream;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kafkalab.model.KafkaMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Produces {@link KafkaMessage} events to the demo Kafka topic.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaMessageProducer {
    private static final String TOPIC_NAME = "companies";

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    /**
     * Sends a message to the configured topic.
     *
     * @param message payload to publish
     */
    public void sendToTopic(KafkaMessage message) {
        log.info("Outgoing Message - Producing -> {}", message);
        kafkaTemplate.send(TOPIC_NAME, message);
    }
}
