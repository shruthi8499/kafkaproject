package com.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DisasterRecoveryListener {

    @KafkaListener(topics = "disaster-recovery-logs")
    public void processDisasterRecoveryLog(String logMessage) {
        try {
            String logEntry = buildLogEntry(logMessage);
            saveLogToFile(logEntry);
            System.out.println("Disaster recovery log saved: " + logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String buildLogEntry(String logMessage) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "[" + now.format(formatter) + "] " + logMessage + "\n";
    }

    private void saveLogToFile(String logEntry) throws IOException {
        String filePath = "C:\\Users\\e019851\\Documents\\recoveryfiles"; // Specify the desired file path

        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(logEntry);
        }
    }
}*/


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DisasterRecoveryListener {

    static final Logger logger = LogManager.getLogger(DisasterRecoveryListener.class);

    @KafkaListener(topics = "${kafka.topic}")
    public void processDisasterRecoveryLog(String logMessage) {
        try {
            String logEntry = buildLogEntry(logMessage);
            saveLogToFile(logEntry);
            logger.info("Disaster recovery log saved: {}", logMessage);
        } catch (IOException e) {
            logger.error("Error saving disaster recovery log: {}", e.getMessage(), e);
        }
    }

    private String buildLogEntry(String logMessage) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "[" + now.format(formatter) + "] " + logMessage + "\n";
    }

    private void saveLogToFile(String logEntry) throws IOException {
        String filePath = "C:\\Users\\e019851\\Documents\\recoveryfiles"; // Specify the desired file path

        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(logEntry);
        }
    }
}



