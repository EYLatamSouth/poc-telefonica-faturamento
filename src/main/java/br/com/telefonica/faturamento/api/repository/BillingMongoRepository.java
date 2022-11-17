package br.com.telefonica.faturamento.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.telefonica.faturamento.api.model.BillingMongoDB;

@Repository
public interface BillingMongoRepository extends MongoRepository<BillingMongoDB, Integer>{

}
