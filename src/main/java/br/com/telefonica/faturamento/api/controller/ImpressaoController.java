package br.com.telefonica.faturamento.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.telefonica.faturamento.api.model.Impressao;
import br.com.telefonica.faturamento.api.repository.ImpressaoRepository;
import br.com.telefonica.faturamento.api.service.ImpressaoService;

@RestController
@RequestMapping("/impressao")
public class ImpressaoController {

	@Autowired
	private ImpressaoService impressaoService;
	
	@Autowired
	ImpressaoRepository impressaoRepository;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Impressao> listAllImpressoes() {
		return impressaoRepository.findAll();
	}
	
	@GetMapping("/{impressaoId}")
	public Impressao findById(@PathVariable Integer impressaoId) {
		return impressaoService.findOrFail(impressaoId);
	}
	
	@DeleteMapping("/{impressaoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteImpressao(@PathVariable Integer impressaoId) {
		impressaoService.deletar(impressaoId);
	}	
}
