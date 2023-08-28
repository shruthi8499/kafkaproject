package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.controller")
public class Deadletterqueue12Application {

	public static void main(String[] args) {
		SpringApplication.run(Deadletterqueue12Application.class, args);
	}

}
