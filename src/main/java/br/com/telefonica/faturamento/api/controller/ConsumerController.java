package br.com.telefonica.faturamento.api.controller;//package br.com.telefonica.faturamento.api.controller;

import br.com.telefonica.faturamento.api.repository.ConsumerRepositoryImpl;
import br.com.telefonica.faturamento.messaging.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerController {

    @Autowired
    Consumer consumer;

    @Autowired
    ConsumerRepositoryImpl consumerRepository;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, String> payload){
        consumerRepository.consume(payload, payload.topic());
    }

}
