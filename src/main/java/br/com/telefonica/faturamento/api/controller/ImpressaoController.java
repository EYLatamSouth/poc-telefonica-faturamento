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

import br.com.telefonica.faturamento.api.model.Impressao;
import br.com.telefonica.faturamento.api.service.ImpressaoService;

@RestController
@RequestMapping("/impressao")
public class ImpressaoController {

	@Autowired
	private ImpressaoService impressaoService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Impressao> listAllImpressaos() {
		return impressaoService.listAll();
	}
	
	@GetMapping("/{billinId}")
	public Impressao findById(@PathVariable Long ImpressaoId) {
		return impressaoService.findById(ImpressaoId);
	}
	
	@DeleteMapping("/{billinId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteImpressao(@PathVariable Long impressaoId) {
		impressaoService.deletePrintQueue(impressaoId);
	}	
}
