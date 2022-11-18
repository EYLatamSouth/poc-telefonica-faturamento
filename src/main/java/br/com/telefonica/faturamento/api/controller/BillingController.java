package br.com.telefonica.faturamento.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.telefonica.faturamento.api.exception.EntidadeNaoEncontradaException;
import br.com.telefonica.faturamento.api.model.Faturamento;
import br.com.telefonica.faturamento.api.repository.BillingRepository;
import br.com.telefonica.faturamento.api.service.BillingService;
import br.com.telefonica.faturamento.messaging.Producer;

@RestController
@RequestMapping("/billings")
public class BillingController {

	
	Producer producer;
	
	@Autowired
	private BillingService billingService;
	
	@Autowired
	private BillingRepository billingRepository;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Faturamento> listAllBillings() {
		return billingRepository.findAll();
	}
	
	@GetMapping("/{billingId}")
	public Faturamento findById(@PathVariable String billingId) {
		return billingService.findOrFail(billingId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Faturamento addNewBilling(@RequestBody Faturamento billing) {
		Faturamento billingSaved = billingService.save(billing);
		return billingSaved;
	}
	
	@DeleteMapping("/{billingId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBilling(@PathVariable String billingId) {
		billingService.deleteBilling(billingId);
	}
	
	@PutMapping("/{billingId}")
	public Faturamento updateBilling(@PathVariable String billingId, @RequestBody Faturamento billing) {
		Faturamento currentBilling = billingService.findOrFail(billingId);
		BeanUtils.copyProperties(billing, currentBilling, "billing_id");
		try {
			return billingService.save(currentBilling);			
		} catch (EntidadeNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
}
