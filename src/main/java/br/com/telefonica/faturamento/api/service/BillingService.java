package br.com.telefonica.faturamento.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.telefonica.faturamento.api.model.Billing;
import br.com.telefonica.faturamento.api.repository.BillingRepository;

@Service
public class BillingService {
	
	@Autowired
	BillingRepository billingRepository;
	
	public List<Billing> listAll() {
		List<Billing> billigList = billingRepository.findAll();
		return billigList;
	}
	
	public Billing findById(Long billingId) {
		Optional<Billing> billing = billingRepository.findById(billingId);
		
		if (billing.isPresent()) {
			return billing.get();
		}
		return null;
	}
	
	public void deleteBilling(Long billingId) {
		billingRepository.deleteById(billingId);
	}

	
	public Billing save(Billing billing) {
		Billing billingSaved = billingRepository.save(billing);
		return billingSaved;
	}
	
	public Billing findOrFail(Long billingId) {
		Billing billing = new Billing();
		billing.setId(Long.valueOf(1));
		billing.setName("Billing1");
		
		return billing;
	}
		
}
