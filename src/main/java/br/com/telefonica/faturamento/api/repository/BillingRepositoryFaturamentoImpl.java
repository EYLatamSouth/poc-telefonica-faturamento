package br.com.telefonica.faturamento.api.repository;

import br.com.telefonica.faturamento.api.exception.EntidadeNaoEncontradaException;
import br.com.telefonica.faturamento.api.service.BillingServiceFaturamentoHexagonal;
import br.com.telefonica.faturamento.api.model.Faturamento;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Inbound Interface - API Calls
@Service
public class BillingRepositoryFaturamentoImpl implements BillingServiceFaturamentoHexagonal {

    @Autowired
    private BillingRepositoryHexagonal billingRepositoryFaturamentoHexagonal;

    @Override
    public void deleteBilling(Integer billingId) {
        billingRepositoryFaturamentoHexagonal.deleteById(billingId);
    }

    @Override
    public Faturamento save(Faturamento billing) {
        return billingRepositoryFaturamentoHexagonal.save(billing);
    }

    @Override
    public Faturamento findOrFail(Integer billingId) {
        return billingRepositoryFaturamentoHexagonal.findById(billingId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(billingId));
    }

    @Override
    public List<Faturamento> findAll() {
        return billingRepositoryFaturamentoHexagonal.findAll();
    }

    @Override
    public Faturamento updateBilling(Faturamento billing, Integer billingId) {
        Faturamento currentBilling = billingRepositoryFaturamentoHexagonal.findById(billingId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(billingId));
        BeanUtils.copyProperties(billing, currentBilling, "billing_id");
        try {
            return billingRepositoryFaturamentoHexagonal.save(currentBilling);
        } catch (EntidadeNaoEncontradaException e) {
            throw new EntidadeNaoEncontradaException(e.getMessage());
        }
    }
}