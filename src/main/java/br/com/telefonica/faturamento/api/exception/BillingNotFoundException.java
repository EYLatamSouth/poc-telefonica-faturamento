package br.com.telefonica.faturamento.api.exception;

public class BillingNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public BillingNotFoundException(String message) {
		super(message);
	}

	public BillingNotFoundException(Long billingId) {
		this(String.format("Não existe um billing com código %d", billingId));
	}
}
