package com.rest;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "test-topic", groupId = "group-id")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
