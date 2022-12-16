package br.com.telefonica.faturamento.messaging;

import br.com.telefonica.faturamento.api.repository.ProducerRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.telefonica.faturamento.api.model.BillingMongoDB;

@Service
public class Producer {
    @Value("${topic.name.producer}")
    private String topicName;

    private KafkaTemplate<String, BillingMongoDB> kafkaTemplate = null;
    
    public Producer(@Value("${topic.name.producer}") String topic,  KafkaTemplate<String, BillingMongoDB> kafkaTemplate) {
        this.topicName = topic;
        this.kafkaTemplate = kafkaTemplate;
	}

    public String getTopicName() {
        return this.topicName;
    }

    public KafkaTemplate<String, BillingMongoDB> getKafkaTemplate() {
        return this.kafkaTemplate;
    }
}
