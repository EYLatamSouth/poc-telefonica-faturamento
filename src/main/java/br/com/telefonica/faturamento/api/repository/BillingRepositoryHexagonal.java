package br.com.telefonica.faturamento.api.repository;

import br.com.telefonica.faturamento.api.model.Faturamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Outbound Interface - Database Calls
@Repository
public interface BillingRepositoryHexagonal extends JpaRepository<Faturamento, Integer> {}