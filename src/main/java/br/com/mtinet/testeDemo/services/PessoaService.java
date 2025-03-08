package br.com.mtinet.testeDemo.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.mtinet.testeDemo.exceptions.CustomSistemaException;
import br.com.mtinet.testeDemo.exceptions.UsuarioValidacaoException;
import br.com.mtinet.testeDemo.interfaces.IPessoa;
import br.com.mtinet.testeDemo.interfaces.IPessoaService;
import br.com.mtinet.testeDemo.model.Pessoa;
import br.com.mtinet.testeDemo.repositorys.PessoaRepository;
import lombok.NoArgsConstructor;

@Service
public class PessoaService implements IPessoaService {


    private PessoaRepository repository;

    public PessoaService( PessoaRepository repository ) {
        this.repository = repository;
    }


    public IPessoa inserir(IPessoa dto)  {
        this.validarDadosUsuario(dto);
        Pessoa entity = new Pessoa();
        BeanUtils.copyProperties(dto,entity);
        entity.setUsuario("tales");
        entity.setDataCadastro(LocalDateTime.now());
        entity.setDataAtualizacao(LocalDateTime.now());
        return repository.save(entity);
    }

    public void validarDadosUsuario(IPessoa dto)  {
        List<String> erros = new ArrayList<>();
        if (dto == null) erros.add("Objeto pessoa nula!" );

        if (dto.getId() == null) erros.add(" - Id do usuário nulo!" );
        else if (dto.getId().trim().length()<1) erros.add(" - O id da pessoa não pode ficar sem valor!" );
        if (dto.getNome() == null) erros.add(" - Nome do usuário nulo!" );
        else if (dto.getNome().trim().length()<1) erros.add(" - Nome da pessoa não pode ficar sem valor!" );

        if (erros.size() == 1) throw new CustomSistemaException(HttpStatus.CONFLICT, "ATENÇÃO! O campo '" + erros.get(0) + "'' com problema.");
        if (erros.size() > 1) throw new CustomSistemaException(HttpStatus.CONFLICT, "ATENÇÃO! Foram identicados problema nos campos abaixo:", erros);

    }

}
