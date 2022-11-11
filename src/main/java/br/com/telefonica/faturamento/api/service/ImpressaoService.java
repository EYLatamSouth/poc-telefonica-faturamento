package br.com.telefonica.faturamento.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.telefonica.faturamento.api.model.Impressao;
import br.com.telefonica.faturamento.api.repository.ImpressaoRepository;

@Service
public class ImpressaoService {

	@Autowired
	ImpressaoRepository impressaoRepository;
	
	public List<Impressao> listAll() {
		List<Impressao> impressaoList = impressaoRepository.findAll();
		return impressaoList;
	}
	
	public Impressao findById(Long impressaoId) {
		Optional<Impressao> impressao = impressaoRepository.findById(impressaoId);
		
		if (impressao.isPresent()) {
			return impressao.get();
		}
		return null;
	}
	
	public void deletePrintQueue(Long impressaoId) {
		impressaoRepository.deleteById(impressaoId);
	}
		
}
