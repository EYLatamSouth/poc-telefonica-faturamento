package br.com.telefonica.faturamento.api.controller;
import br.com.telefonica.faturamento.api.model.BillingMongoDB;
import br.com.telefonica.faturamento.api.repository.ProducerRepositoryImpl;
import br.com.telefonica.faturamento.messaging.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerController {

    @Autowired
    Producer producer;

    @Autowired
    ProducerRepositoryImpl producerRepository;

    public void send(BillingMongoDB billing){
        producerRepository.send(billing, producer.getKafkaTemplate(), producer.getTopicName());
    }

}
