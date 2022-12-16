package br.com.telefonica.faturamento.api.repository;

import br.com.telefonica.faturamento.api.exception.EntidadeEmUsoException;
import br.com.telefonica.faturamento.api.exception.EntidadeNaoEncontradaException;
import br.com.telefonica.faturamento.api.model.Impressao;
import br.com.telefonica.faturamento.api.service.ImpressaoServiceHexagonal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpressaoRepositoryImpl implements ImpressaoServiceHexagonal {

    @Autowired
    private ImpressaoRepositoryHexagonal impressaoRepository;

    private static final String IMPRESSAO_EM_USO = "A Impressao de código %b não pode ser removida, pois está em uso";

    @Override
    public List<Impressao> listAllImpressoes() {
        return impressaoRepository.findAll();
    }

    @Override
    public Impressao findById(String impressaoId) {
        Optional<Impressao> impressao = impressaoRepository.findById(impressaoId);

        if (impressao.isPresent()) {
            return impressao.get();
        }
        return null;
    }

    @Override
    public void delete(String impressaoId) {
        try {
            impressaoRepository.deleteById(impressaoId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(impressaoId);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(IMPRESSAO_EM_USO, impressaoId));
        }
    }

    @Override
    public Impressao findOrFail(String impressaoId) {
        return impressaoRepository.findById(impressaoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(impressaoId));
    }
}
