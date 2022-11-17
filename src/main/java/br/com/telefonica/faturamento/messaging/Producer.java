package br.com.telefonica.faturamento.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.telefonica.faturamento.api.model.Billing;
import br.com.telefonica.faturamento.api.model.BillingMongoDB;

@Service
public class Producer {

	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	
    @Value("${topic.name.producer}")
    private String topicName;

    private KafkaTemplate<String, BillingMongoDB> kafkaTemplate = null;
    
    public Producer(@Value("${topic.name.producer}") String topic,  KafkaTemplate<String, BillingMongoDB> kafkaTemplate) {
        this.topicName = topic;
        this.kafkaTemplate = kafkaTemplate;
	}

    public void send(BillingMongoDB billing){
        kafkaTemplate.send(topicName, billing).addCallback(
                success -> logger.info("Messagem send: " + success.getProducerRecord().value()),
                failure -> logger.info("Message failure: " + failure.getMessage())
        );
    }
}
