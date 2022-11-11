package br.com.telefonica.faturamento.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.telefonica.faturamento.api.model.Billing;

public interface BillingRepository extends MongoRepository<Billing, Long>{

}
