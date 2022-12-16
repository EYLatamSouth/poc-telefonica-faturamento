package br.com.telefonica.faturamento.api.service;
import br.com.telefonica.faturamento.api.model.Impressao;
import org.springframework.stereotype.Service;

import java.util.List;

//Inbound Interface - API Calls
@Service
public interface ImpressaoServiceHexagonal {
	public List<Impressao> listAllImpressoes();
	public Impressao findById(String impressaoId);
	public void delete(String impressaoId);
	public Impressao findOrFail(String impressaoId);
}
