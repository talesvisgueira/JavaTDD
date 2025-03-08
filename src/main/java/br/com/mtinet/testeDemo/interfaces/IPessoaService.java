package br.com.mtinet.testeDemo.interfaces;

import br.com.mtinet.testeDemo.exceptions.UsuarioValidacaoException;

public interface IPessoaService {

    public IPessoa inserir(IPessoa pessoa) throws UsuarioValidacaoException   ;

}
