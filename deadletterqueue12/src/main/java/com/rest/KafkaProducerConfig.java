package com.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfig {
    @Bean
    public KafkaTemplate<String, DeadLetterMessage> kafkaTemplate(ProducerFactory<String, DeadLetterMessage> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
