package br.com.mtinet.testeDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.mtinet.testeDemo.dto.PessoaDto;
import br.com.mtinet.testeDemo.interfaces.IPessoa;
import br.com.mtinet.testeDemo.model.Pessoa;
import br.com.mtinet.testeDemo.services.PessoaService;


@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping()
    public ResponseEntity<IPessoa> inserir(@RequestBody PessoaDto pessoa) {
         
        IPessoa entity = service.inserir(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }
}
