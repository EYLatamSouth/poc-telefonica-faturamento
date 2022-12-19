package br.com.telefonica.faturamento.api.service;

import br.com.telefonica.faturamento.api.model.BillingMongoDB;
import br.com.telefonica.faturamento.api.model.Faturamento;
import org.springframework.stereotype.Service;

import java.util.List;

//Inbound Interface - API Calls
@Service
public interface BillingServiceMongoDbHexagonal {
	public BillingMongoDB save(BillingMongoDB billingMongoDB);
}
