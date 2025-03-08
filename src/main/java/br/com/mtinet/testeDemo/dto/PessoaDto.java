package br.com.mtinet.testeDemo.dto;

import java.time.LocalDateTime;

import br.com.mtinet.testeDemo.interfaces.IPessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto implements IPessoa {

    private String id;
    private String nome;
    private String usuario;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;

}
