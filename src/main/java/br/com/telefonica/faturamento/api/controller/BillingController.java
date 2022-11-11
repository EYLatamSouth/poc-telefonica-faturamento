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

import br.com.telefonica.faturamento.api.model.Billing;
import br.com.telefonica.faturamento.api.service.BillingService;

@RestController
@RequestMapping("/billings")
public class BillingController {

	@Autowired
	private BillingService billingService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Billing> listAllBillings() {
		return billingService.listAll();
	}
	
	@GetMapping("/{billinId}")
	public Billing findById(@PathVariable Long billingId) {
		return billingService.findById(billingId);
	}
	
	@DeleteMapping("/{billinId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBilling(@PathVariable Long billingId) {
		billingService.deleteBilling(billingId);
	}
	
	@PutMapping("/{billinId}")
	public Billing updateBilling(@PathVariable Long billingId, @RequestBody Billing billing) {
		Billing currentBilling = billingService.findOrFail(billingId);
		BeanUtils.copyProperties(billing, currentBilling, "id");
		return billingService.save(currentBilling);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Billing addNewBilling(@RequestBody Billing billing) {
		Billing billingSaved = billingService.save(billing);
		return billingSaved;
	}
}
