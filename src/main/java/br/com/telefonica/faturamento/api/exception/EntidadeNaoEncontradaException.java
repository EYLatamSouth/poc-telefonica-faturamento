package br.com.telefonica.faturamento.api.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EntidadeNaoEncontradaException(String message) {
		super(message);
	}

	public EntidadeNaoEncontradaException(Integer entidadeId) {
		this(String.format("Não existe uma entidade com código %d", entidadeId));
	}
}
