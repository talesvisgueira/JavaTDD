package br.com.mtinet.testeDemo.interfaces;

import java.time.LocalDateTime;

public interface IPessoa {

    public String getId();

    public String getNome();

    public String getUsuario();

    public LocalDateTime getDataCadastro();

    public LocalDateTime getDataAtualizacao();

}

