package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.KafkaSender;

@RestController
public class KafkaProducerController {

	
	@Autowired
	KafkaSender kafkaSender;
	
	@GetMapping("/")
	public String hello() {
	
		return "Welcome to kafka message using Springboot application";
	}
	
	@PostMapping("/producer/{message}")
	public String producer(@PathVariable String message) {
		kafkaSender.send(message);
		
		return "Message sent to the Kafka topic successfully";
	}
	
	
}
