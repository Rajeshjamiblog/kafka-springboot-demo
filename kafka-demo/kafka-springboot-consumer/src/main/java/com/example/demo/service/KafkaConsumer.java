package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	String consumedMesssage;
	
	@KafkaListener(topics = "first_topic_test1", groupId = "G1")
	public void consume(String message) {
		
		Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
		
		consumedMesssage = message;
		
		log.info("Consumed Message :: "+message);
	}
	
	
	
	public String getConsumedMessage() {
		return consumedMesssage;
	}
	
}
