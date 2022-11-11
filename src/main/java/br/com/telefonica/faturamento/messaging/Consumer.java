package br.com.telefonica.faturamento.messaging;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class Consumer {

	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
	
    @Value("${topic.name.consumer}")
    private String topicName;
    
    @KafkaListener(topics = "${topic.name.consumer}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, String> payload){
    	logger.info("Tópico: {}", topicName);
    	logger.info("key: {}", payload.key());
    	logger.info("Headers: {}", payload.headers());
    	logger.info("Partion: {}", payload.partition());
    	logger.info("Order: {}", payload.value());

    }
}
