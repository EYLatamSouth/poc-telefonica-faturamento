package br.com.telefonica.faturamento.api.service;

import br.com.telefonica.faturamento.api.model.BillingMongoDB;
import br.com.telefonica.faturamento.api.model.Faturamento;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//Inbound Interface - API Calls
@Service
public interface BillingServiceFaturamentoHexagonal {
	public void deleteBilling(Integer billingId);
	public Faturamento save(Faturamento billing) throws Exception;
	public Faturamento findOrFail(Integer billingId);
	public List<Faturamento> findAll();
	public Faturamento updateBilling(Faturamento billing, Integer billingId);
}
