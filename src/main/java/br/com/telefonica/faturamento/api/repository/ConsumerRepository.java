package br.com.telefonica.faturamento.api.repository;

import br.com.telefonica.faturamento.api.model.BillingMongoDB;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository {

	public void consume(ConsumerRecord<String, String> payload, String topicName);
}