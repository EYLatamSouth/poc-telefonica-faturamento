package br.com.telefonica.faturamento.api.repository;

import br.com.telefonica.faturamento.api.model.BillingMongoDB;
import br.com.telefonica.faturamento.api.service.BillingServiceMongoDbHexagonal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Inbound Interface - API Calls
@Service
public class BillingRepositoryMongoDBImpl implements BillingServiceMongoDbHexagonal {

    @Autowired
    private BillingMongoRepositoryHexagonal billingRepositoryFaturamentoHexagonal;

    @Override
    public BillingMongoDB save(BillingMongoDB billingMongoDB) {
        return billingRepositoryFaturamentoHexagonal.save(billingMongoDB);
    }
}