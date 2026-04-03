package org.kafkalab.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kafkalab.data.KafkaMessageRepository;
import org.kafkalab.model.KafkaMessage;
import org.kafkalab.model.KafkaMessageEntity;
import org.kafkalab.stream.KafkaMessageProducer;
import org.springframework.stereotype.Service;

/**
 * Coordinates publishing messages to Kafka and storing a local demo record.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MessageService {
    private final KafkaMessageProducer kafkaMessageProducer;
    private final KafkaMessageRepository kafkaMessageRepository;

    /**
     * Publishes a message to Kafka and saves a copy in H2 for learning visibility.
     *
     * @param kafkaMessage payload sent from the API layer
     */
    public void publishMessage(KafkaMessage kafkaMessage) {
        log.info("Publishing payload: {}", kafkaMessage);
        kafkaMessageProducer.sendToTopic(kafkaMessage);

        KafkaMessageEntity kafkaMessageEntity = new KafkaMessageEntity();
        kafkaMessageEntity.setData(kafkaMessage.getData());
        kafkaMessageRepository.save(kafkaMessageEntity);
    }
}
