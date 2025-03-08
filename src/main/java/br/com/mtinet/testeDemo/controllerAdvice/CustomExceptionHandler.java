package br.com.mtinet.testeDemo.controllerAdvice;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.mtinet.testeDemo.exceptions.ApiErrorMessage;
import br.com.mtinet.testeDemo.exceptions.CustomSistemaException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler  {

	@ExceptionHandler(CustomSistemaException.class)
	public ResponseEntity<Object> handleConstraintViolationException(CustomSistemaException ex, WebRequest request) {
			// ApiErrorMessage apiErrorMessage  = new ApiErrorMessage(HttpStatusCode.valueOf(ex.getStatus().value()), ex.getLocalizedMessage()  );
			ex.getStatus().value();
			ApiErrorMessage apiErrorMessage  = new ApiErrorMessage(HttpStatus.valueOf(ex.getStatus().value()),"");
			return new ResponseEntity<>(apiErrorMessage, new HttpHeaders(), apiErrorMessage.getStatus());
	}

}

