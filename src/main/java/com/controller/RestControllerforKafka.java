/*package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.KafkaProducer;

@RestController
@RequestMapping("/rest/api")
public class RestControllerforKafka {

	@Autowired
    KafkaProducer kafkaproducer;


    @GetMapping("/producerMsg")
    public void getMessageFromClient(@RequestParam("message") String message)
    {
        kafkaproducer.sendMessageToTopic(message);
        
    }
	
}*/