package br.com.telefonica.faturamento.api.controller;

import br.com.telefonica.faturamento.api.exception.EntidadeNaoEncontradaException;
import br.com.telefonica.faturamento.api.model.Faturamento;
import br.com.telefonica.faturamento.api.service.BillingServiceFaturamentoHexagonal;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//***Primary Adapter***

@RestController
@RequestMapping("/billings")
@Service
public class BillingControllerHexagonal {
	@Autowired
	private BillingServiceFaturamentoHexagonal billingService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Faturamento> listAllBillings() {
		return billingService.findAll();
	}

	@GetMapping("/{billingId}")
	public Faturamento findById(@PathVariable Integer billingId) {return billingService.findOrFail(billingId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Faturamento addNewBilling(@RequestBody Faturamento billing) throws Exception {
		Faturamento billingSaved = billingService.save(billing);
		return billingSaved;
	}
	
	@DeleteMapping("/{billingId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBilling(@PathVariable Integer billingId) {
		billingService.deleteBilling(billingId);
	}
	
	@PutMapping("/{billingId}")
	public Faturamento updateBilling(@RequestBody Faturamento billing, @PathVariable Integer billingId) {
		return billingService.updateBilling(billing, billingId);
	}
}
