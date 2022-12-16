package br.com.telefonica.faturamento.api.repository;

import br.com.telefonica.faturamento.api.model.BillingMongoDB;
import br.com.telefonica.faturamento.messaging.Producer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository {

	public void send(BillingMongoDB billing, KafkaTemplate<String, BillingMongoDB> kafkaTemplate, String topicName);
}