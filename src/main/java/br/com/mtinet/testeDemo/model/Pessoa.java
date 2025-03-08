package br.com.mtinet.testeDemo.model;



import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.mtinet.testeDemo.interfaces.IPessoa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TB_PESSOA")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa implements IPessoa, Serializable {

    @Id
    @Column(name = "ID_PESSOA", nullable = false)
    private String id;
    private String nome;
    private String usuario;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;

}
