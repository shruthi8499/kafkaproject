package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.DeadLetterMessage;

@RestController
@RequestMapping("/admin/dead-letter")
public class DeadLetterController {
    private final KafkaTemplate<String, DeadLetterMessage> kafkaTemplate;
    private static final String DEAD_LETTER_TOPIC = "dead-letter";

    @Autowired
    public DeadLetterController(KafkaTemplate<String, DeadLetterMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/republish")
    public ResponseEntity<String> republishToOriginalTopic(@RequestBody DeadLetterMessage message) {
        // Publish the message back to the original topic
        kafkaTemplate.send(message.getOriginalTopic(), message);
        return ResponseEntity.ok("Message republished to the original topic.");
    }
}
