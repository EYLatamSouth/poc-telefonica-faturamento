package br.com.telefonica.faturamento.api.service;//package br.com.telefonica.faturamento.api.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Service;
//
//import br.com.telefonica.faturamento.api.exception.EntidadeEmUsoException;
//import br.com.telefonica.faturamento.api.exception.EntidadeNaoEncontradaException;
//import br.com.telefonica.faturamento.api.model.Faturamento;
//import br.com.telefonica.faturamento.api.model.BillingMongoDB;
//import br.com.telefonica.faturamento.api.repository.BillingMongoRepository;
//import br.com.telefonica.faturamento.api.repository.BillingRepository;
//
//@Service
//public class BillingService {
//
//	private static final String BILLING_EM_USO = "O Billing de código %b não pode ser removido, pois está em uso";
//
//	@Autowired
//	BillingRepository billingRepository;
//
//	@Autowired
//	BillingMongoRepository billingMongoRepository;
//
//	public void deleteBilling(Integer billingId) {
//		try {
//			billingRepository.deleteById(billingId);
//		} catch (EmptyResultDataAccessException e) {
//			throw new EntidadeNaoEncontradaException(billingId);
//		} catch (DataIntegrityViolationException e) {
//			throw new EntidadeEmUsoException(String.format(BILLING_EM_USO, billingId));
//		}
//	}
//
//	public Faturamento save(Faturamento billing) {
//		Faturamento billingSaved = billingRepository.save(billing);
//		return billingSaved;
//	}
//
//	public BillingMongoDB save(BillingMongoDB billingMongoDB) {
//		BillingMongoDB billingSaved = billingMongoRepository.save(billingMongoDB);
//		return billingSaved;
//	}
//
//	public Faturamento findOrFail(Integer billingId) {
//		return billingRepository.findById(billingId)
//				.orElseThrow(() -> new EntidadeNaoEncontradaException(billingId));
//	}
//}
