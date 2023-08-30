package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PendingMessageRecoveryService {
    @Autowired
    private PendingMessageRepository pendingMessageRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void recoverPendingMessages(String clientId) {
        List<PendingMessage> pendingMessages = pendingMessageRepository.findByClientId(clientId);
        for (PendingMessage pendingMessage : pendingMessages) {
            kafkaTemplate.send(clientId, pendingMessage.getContent());
            pendingMessageRepository.delete(pendingMessage);
            System.out.println("Recovered and sent pending message: " + pendingMessage);
        }
    }
}




