package br.com.telefonica.faturamento.api.exception;

public class FaturamentoStatusInvalidoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public FaturamentoStatusInvalidoException(String message) {
        super(message);
    }

    public FaturamentoStatusInvalidoException(Integer entidadeId) {
        this(String.format("Não foi possível processar o faturamento pois o status é diferente de 1, billing_id: %b", entidadeId));
    }
}
