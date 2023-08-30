package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private PendingMessageRecoveryService recoveryService;

    @PostMapping("/send-pending-messages")
    public String sendPendingMessages(@RequestParam String clientId, @RequestParam String message) {
        kafkaTemplate.send("pending-messages-topic", clientId + ":" + message);
        System.out.println("Sent pending message: " + message);
        return "Pending message sent";
    }

    @PostMapping("/recover-pending-messages")
    public String recoverPendingMessages(@RequestParam String clientId) {
        recoveryService.recoverPendingMessages(clientId);
        return "Pending messages recovery initiated";
    }
}

