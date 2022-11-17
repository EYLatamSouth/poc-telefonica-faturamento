package br.com.telefonica.faturamento.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.telefonica.faturamento.api.exception.EntidadeEmUsoException;
import br.com.telefonica.faturamento.api.exception.EntidadeNaoEncontradaException;
import br.com.telefonica.faturamento.api.model.Impressao;
import br.com.telefonica.faturamento.api.repository.ImpressaoRepository;

@Service
public class ImpressaoService {

	@Autowired
	ImpressaoRepository impressaoRepository;
	
	private static final String IMPRESSAO_EM_USO = "A Impressao de código %d não pode ser removida, pois está em uso";
	
	public Impressao findById(Integer impressaoId) {
		Optional<Impressao> impressao = impressaoRepository.findById(impressaoId);
		
		if (impressao.isPresent()) {
			return impressao.get();
		}
		return null;
	}
	
	public void deletar(Integer impressaoId) {
		try {
			impressaoRepository.deleteById(impressaoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(impressaoId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(IMPRESSAO_EM_USO, impressaoId));
		}
	}	
	
	public Impressao findOrFail(Integer impressaoId) {
		return impressaoRepository.findById(impressaoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(impressaoId));
	}
		
}
