package br.com.telefonica.faturamento.api.exception;

public enum ProblemType {

	ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
	STATUS_INVALIDO("/status-invalido", "Status invalido");
	
	private String title;
	private String uri;
	
	private ProblemType(String path, String title) {
		this.uri = path;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public String getUri() {
		return uri;
	}
}
