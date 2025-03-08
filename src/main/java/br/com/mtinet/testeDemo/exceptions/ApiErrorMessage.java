package br.com.mtinet.testeDemo.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ApiErrorMessage {

	private HttpStatus status;
    private List<String> errors;

    public ApiErrorMessage(HttpStatus status, List<String> errors) {
        super();
        this.status = status;
        this.errors = errors;
    }

    public ApiErrorMessage(HttpStatus status, String error) {
        super();
        this.status = status;
        errors = Arrays.asList(error);
    }

}
