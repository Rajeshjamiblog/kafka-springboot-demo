package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {

	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	int count = 0;
	
	String kafkaTopic = "first_topic_test1";
	
	
	Logger log = LoggerFactory.getLogger(KafkaSender.class);
	
	
	@Scheduled(fixedRate = 2000)
	public void sendperiodically() {
		count++;
		
		kafkaTemplate.send(kafkaTopic, "message Count "+ count);
		
		log.info("message count : "+count);
	}
	
	
	public void send(String message) {
		
		kafkaTemplate.send(kafkaTopic, message);
		
	}
	
	
}
