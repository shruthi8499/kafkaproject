package com.rest;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MessageLogger {

    @Value("${message.log.filepath}") // Path to the log file, configured in application.properties
    private String logFilePath;

    @KafkaListener(topics = "${kafka.topic}") // Topic to consume messages from, configured in application.properties
    public void logMessage(ConsumerRecord<String, String> record) {
        try {
            System.out.println("Received message: " + record.value()); // Debug statement
            String logEntry = buildLogEntry(record);
            System.out.println("Log entry: " + logEntry); // Debug statement
            writeLogToFile(logEntry);
            System.out.println("Message logged successfully."); // Debug statement
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO exception");
        }
    }

    private String buildLogEntry(ConsumerRecord<String, String> record) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "[" + now.format(formatter) + "] " + record.value() + "\n";
    }

    private void writeLogToFile(String logEntry) throws IOException {
        try (FileWriter writer = new FileWriter(logFilePath, true)) {
            writer.write(logEntry);
        }
    }
}
