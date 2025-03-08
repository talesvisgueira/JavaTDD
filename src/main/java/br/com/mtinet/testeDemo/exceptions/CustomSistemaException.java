package br.com.mtinet.testeDemo.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomSistemaException extends RuntimeException  {

	private static final long serialVersionUID = -182700265192389780L;

	@Getter
	private HttpStatusCode status  ;

	@Getter
	private String mensagem;

	@Getter
	private List<String> erros = new ArrayList<String>();


	public CustomSistemaException(HttpStatusCode status,String mensagem ) {
		this.status = status;
		this.mensagem =  mensagem;
	}

	public CustomSistemaException(HttpStatusCode status,String mensagem,  List<String> errors) {
		this.status = status;
		this.mensagem =  mensagem;
		this.erros.addAll(erros);
	}

}
