package org.kafkalab.controller;

import lombok.RequiredArgsConstructor;
import org.kafkalab.model.KafkaMessage;
import org.kafkalab.service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller exposing endpoints to publish demo Kafka messages.
 */
@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    /**
     * Receives a JSON message payload and forwards it to the service layer.
     *
     * @param kafkaMessage request payload to publish
     */
    @PostMapping(value = "/send", consumes = {"application/json"}, produces = {"application/json"})
    public void publishMessage(@RequestBody KafkaMessage kafkaMessage) {
        messageService.publishMessage(kafkaMessage);
    }
}
