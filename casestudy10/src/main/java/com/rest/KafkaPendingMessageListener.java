package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPendingMessageListener {
    @Autowired
    private PendingMessageRepository pendingMessageRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "pending-messages-topic")
    public void processPendingMessage(String message) {
        String[] parts = message.split(":");
        if (parts.length >= 2) {
            String clientId = parts[0];
            String content = parts[1];

            PendingMessage pendingMessage = new PendingMessage();
            pendingMessage.setClientId(clientId);
            pendingMessage.setContent(content);

            pendingMessageRepository.save(pendingMessage);
            System.out.println("Received and stored pending message: " + pendingMessage);

            // Process the pending message further if needed
            // Example: Send an acknowledgment to another topic
            kafkaTemplate.send("acknowledgment-topic", "Acknowledgment for: " + clientId);
        } else {
            System.out.println("Received message with invalid format: " + message);
        }
    }
}



