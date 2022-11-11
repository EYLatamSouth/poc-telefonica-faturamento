package br.com.telefonica.faturamento.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.telefonica.faturamento.api.model.Impressao;

public interface ImpressaoRepository extends MongoRepository<Impressao, Long>{

}
