package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.KafkaConsumer;

@RestController
public class KafkaConsumerController {

	@Autowired
	KafkaConsumer kafkaConsumer;
	
	@GetMapping("/consumemessage")
	public String getMessage() {
		return kafkaConsumer.getConsumedMessage();
	}
	
}
