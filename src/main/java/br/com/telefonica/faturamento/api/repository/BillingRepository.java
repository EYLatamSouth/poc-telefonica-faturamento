package br.com.telefonica.faturamento.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.telefonica.faturamento.api.model.Billing;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Integer> {
	
}