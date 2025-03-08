package br.com.mtinet.testeDemo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.mtinet.testeDemo.EntityUtil;
import br.com.mtinet.testeDemo.exceptions.CustomSistemaException;
import br.com.mtinet.testeDemo.exceptions.UsuarioValidacaoException;
import br.com.mtinet.testeDemo.interfaces.IPessoa;
import br.com.mtinet.testeDemo.interfaces.IPessoaService;
import br.com.mtinet.testeDemo.repositorys.PessoaRepository;
import br.com.mtinet.testeDemo.services.PessoaService;


@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @InjectMocks
    private PessoaService service;

    @Mock
    private PessoaRepository repository;

    @Test
    @DisplayName("Quando criar uma pessoa retora uma entity pessoa")
    public void criarPessoaComDadosValidosRetornaSucesso() {

        Mockito.when(repository.save(Mockito.any())).thenReturn(EntityUtil.criarNewPessoa());

        IPessoa result = service.inserir(EntityUtil.criarDtoPessoaValida());

        Assertions.assertThatNoException();
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getUsuario());
        assertNotNull(result.getDataCadastro());
        assertNotNull(result.getDataAtualizacao());

    }

    @Test
    public void criarPessoaComDadosInvalidosRetornaExcecao() {
        assertThrows(CustomSistemaException.class, () -> service.inserir(EntityUtil.criarDtoPessoaInvalida()));
    }
}