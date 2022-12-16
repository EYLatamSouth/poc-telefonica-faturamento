package br.com.telefonica.faturamento.api.repository;

import br.com.telefonica.faturamento.api.controller.ProducerController;
import br.com.telefonica.faturamento.api.model.BillingMongoDB;
import br.com.telefonica.faturamento.api.service.BillingServiceMongoDbHexagonal;
import br.com.telefonica.faturamento.messaging.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerRepositoryImpl implements ConsumerRepository {
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);

	@Autowired
	private BillingServiceMongoDbHexagonal billingService;

	@Autowired
	private ProducerController producer;

	@Override
	public void consume(ConsumerRecord<String, String> payload, String topicName) {
		logger.info("Tópico: {}", topicName);
		logger.info("key: {}", payload.key());
		logger.info("Headers: {}", payload.headers());
		logger.info("Partion: {}", payload.partition());
		logger.info("Order: {}", payload.value());

		String dados = payload.value();

		ObjectMapper mapper = new ObjectMapper();
		BillingMongoDB billing;

		try {
			billing = mapper.readValue(dados, BillingMongoDB.class);
		} catch (JsonProcessingException ex) {
			logger.error("Falha ao converter os dados recebidos pelo Consumer [dados={}]", dados, ex);
			return;
		}

		logger.info("Evento Recebido = {}", billing);


		BillingMongoDB billingSaved = billingService.save(billing);

		producer.send(billingSaved);
		logger.info("Finalizou com sucesso o recebimento e envio de evento do Kafka Confluent!!!");
	}
}