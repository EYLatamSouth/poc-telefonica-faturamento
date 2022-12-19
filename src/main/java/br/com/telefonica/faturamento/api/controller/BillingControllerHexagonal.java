package br.com.telefonica.faturamento.api.controller;

import br.com.telefonica.faturamento.api.exception.EntidadeNaoEncontradaException;
import br.com.telefonica.faturamento.api.model.Faturamento;
import br.com.telefonica.faturamento.api.service.BillingServiceFaturamentoHexagonal;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbiden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 422, message = "Unprocessable Entity"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 502, message = "Bad Gateway"),
			@ApiResponse(code = 503, message = "Service Unavailable"),
			@ApiResponse(code = 504, message = "Gateway Timeout"), })
	@GetMapping("/{billingId}")
	public Faturamento findById(@PathVariable Integer billingId) {return billingService.findOrFail(billingId);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbiden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 422, message = "Unprocessable Entity"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 502, message = "Bad Gateway"),
			@ApiResponse(code = 503, message = "Service Unavailable"),
			@ApiResponse(code = 504, message = "Gateway Timeout"), })
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Faturamento addNewBilling(@RequestBody Faturamento billing) throws Exception {
		Faturamento billingSaved = billingService.save(billing);
		return billingSaved;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbiden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 422, message = "Unprocessable Entity"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 502, message = "Bad Gateway"),
			@ApiResponse(code = 503, message = "Service Unavailable"),
			@ApiResponse(code = 504, message = "Gateway Timeout"), })
	@DeleteMapping("/{billingId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBilling(@PathVariable Integer billingId) {
		billingService.deleteBilling(billingId);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbiden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 422, message = "Unprocessable Entity"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 502, message = "Bad Gateway"),
			@ApiResponse(code = 503, message = "Service Unavailable"),
			@ApiResponse(code = 504, message = "Gateway Timeout"), })
	@PutMapping("/{billingId}")
	public Faturamento updateBilling(@RequestBody Faturamento billing, @PathVariable Integer billingId) {
		return billingService.updateBilling(billing, billingId);
	}
}
