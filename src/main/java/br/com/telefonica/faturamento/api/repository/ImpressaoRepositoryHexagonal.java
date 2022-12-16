package br.com.telefonica.faturamento.api.repository;

import br.com.telefonica.faturamento.api.model.Impressao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Outbound Interface - Database Calls
@Repository
public interface ImpressaoRepositoryHexagonal extends JpaRepository<Impressao, String> {}