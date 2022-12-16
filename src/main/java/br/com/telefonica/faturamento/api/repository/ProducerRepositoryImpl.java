package br.com.telefonica.faturamento.api.repository;

import br.com.telefonica.faturamento.api.model.BillingMongoDB;
import br.com.telefonica.faturamento.messaging.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerRepositoryImpl implements ProducerRepository {
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	@Override
	public void send(BillingMongoDB billing, KafkaTemplate<String, BillingMongoDB> kafkaTemplate, String topicName) {
		kafkaTemplate.send(topicName, billing).addCallback(
				success -> logger.info("Messagem send: " + success.getProducerRecord().value()),
				failure -> logger.info("Message failure: " + failure.getMessage())
		);
	}
}