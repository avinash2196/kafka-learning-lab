package org.kafkalab.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * Consumes messages from the demo topic as part of a consumer group.
 */
@Component
@Slf4j
public class KafkaMessageConsumer {

    /**
     * Handles incoming Kafka records and logs payload with partition and offset metadata.
     *
     * @param data consumed message value
     * @param partition partition from which the message was read
     * @param offset offset position of the consumed record
     */
    @KafkaListener(topics = "companies", groupId = "group_id")
    public void consume(
            String data,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.OFFSET) long offset
    ) {
        log.info("Incoming Message -> data: {}, partition: {}, offset: {}", data, partition, offset);
    }
}
