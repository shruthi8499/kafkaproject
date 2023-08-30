package com.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PendingMessageService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final PendingMessageRepository messageRepository;

    @Autowired
    public PendingMessageService(KafkaTemplate<String, String> kafkaTemplate,
                                 PendingMessageRepository messageRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.messageRepository = messageRepository;
    }

    public void sendPendingMessage(String message) {
        kafkaTemplate.send("my-topic", message);
    }

    public void storePendingMessage(String messageContent) {
        PendingMessage pendingMessage = new PendingMessage();
        pendingMessage.setContent(messageContent);
        messageRepository.save(pendingMessage);
    }

    // Other methods as needed
}
