package br.com.telefonica.faturamento.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<Object> handleEntityNotFound(EntidadeNaoEncontradaException ex, WebRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		ProblemType problemType = ProblemType.RECURSO_NAO_ENCONTRADO;
		String detail =  ex.getMessage();
		
		Problem problem = createProblem(status, problemType, detail);
		return super.handleExceptionInternal(ex, problem, null, status, request);
	}
	
	@ExceptionHandler(EntidadeEmUsoException.class)
	public ResponseEntity<Object> handleEntidadeEmUso(EntidadeEmUsoException ex, WebRequest request) {
		
		HttpStatus status = HttpStatus.CONFLICT;
		ProblemType problemType = ProblemType.ENTIDADE_EM_USO;
		String detail =  ex.getMessage();
		
		Problem problem = createProblem(status, problemType, detail);
		return super.handleExceptionInternal(ex, problem, null, status, request);
	}
	
	public ResponseEntity<Object> handleUncaught(Exception ex, WebRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		ProblemType problemType = ProblemType.ERRO_DE_SISTEMA;
		String detail = "Ocorreu um erro interno inesperado no sistema, tente novamente e se persistir entre"
				+ "em contato com o administrador do sistema.";
		Problem problem = createProblem(status, problemType, detail);
		return super.handleExceptionInternal(ex, problem, null, status, request);
	}
	
	private Problem createProblem(HttpStatus status, ProblemType problemType, String detail) {
		Problem problem = new Problem();
		problem.setStatus(status.value());
		problem.setType(problemType.getUri());
		problem.setTitle(problemType.getTitle());
		problem.setDetail(detail);
		
		return problem;
	}
}
