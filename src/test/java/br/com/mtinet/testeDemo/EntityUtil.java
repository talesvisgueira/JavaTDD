package br.com.mtinet.testeDemo;

import java.time.LocalDateTime;

import br.com.mtinet.testeDemo.dto.PessoaDto;
import br.com.mtinet.testeDemo.model.Pessoa;


public  class EntityUtil {
    public static PessoaDto criarDtoPessoaValida() {
        return PessoaDto.builder()
                        .id("35002034349")
                        .nome("TALES")
                        .build();
    }

    public static PessoaDto criarDtoPessoaInvalida() {
        return PessoaDto.builder()
                        .id("35002034349")
                        .nome("")
                        .build();
    }

    public static Pessoa criarNewPessoa() {
        return Pessoa.builder()
                        .id("35002034349")
                        .nome("TALES")
                        .usuario("tales")
                        .dataCadastro(LocalDateTime.now())
                        .dataAtualizacao(LocalDateTime.now())
                        .build();
    }
}
