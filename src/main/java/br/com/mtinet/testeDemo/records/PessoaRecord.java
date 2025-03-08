package br.com.mtinet.testeDemo.records;

import lombok.Builder;

@Builder
public record PessoaRecord(String id, String nome)  { }
