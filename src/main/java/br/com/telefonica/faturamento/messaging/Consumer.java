package br.com.telefonica.faturamento.messaging;
import br.com.telefonica.faturamento.api.repository.ConsumerRepositoryImpl;
import br.com.telefonica.faturamento.api.repository.ProducerRepositoryImpl;
import br.com.telefonica.faturamento.api.service.BillingServiceMongoDbHexagonal;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.telefonica.faturamento.api.model.BillingMongoDB;

@Service
public class Consumer {

	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
	
    @Value("${topic.name.consumer}")
    private String topicName;
}
