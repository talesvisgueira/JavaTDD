package br.com.mtinet.testeDemo.exceptions;

import java.util.ArrayList;
import java.util.List;

public class UsuarioValidacaoException extends Exception {
    private List<String> erros = new ArrayList<>();

    public UsuarioValidacaoException(String mensagem) {
        super(mensagem);
    }

    public UsuarioValidacaoException(String mensagem, List<String> erros) {
        super(mensagem);
        this.erros = erros;
    }

}
