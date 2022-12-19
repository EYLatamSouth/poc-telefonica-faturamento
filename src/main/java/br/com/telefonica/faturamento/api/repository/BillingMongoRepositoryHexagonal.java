package br.com.telefonica.faturamento.api.repository;

import br.com.telefonica.faturamento.api.model.BillingMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingMongoRepositoryHexagonal extends MongoRepository<BillingMongoDB, Integer>{}
