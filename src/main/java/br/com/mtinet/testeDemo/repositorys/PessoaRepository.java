package br.com.mtinet.testeDemo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mtinet.testeDemo.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, String>  {
    
}
