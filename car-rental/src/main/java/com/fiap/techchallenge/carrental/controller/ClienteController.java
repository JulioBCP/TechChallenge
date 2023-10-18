package com.fiap.techchallenge.carrental.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.PutExchange;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiap.techchallenge.carrental.DTO.AtualizaClienteDTO;
import com.fiap.techchallenge.carrental.entity.Cliente;
import com.fiap.techchallenge.carrental.service.CadastroClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteController {
    
    @Autowired
    CadastroClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> inserirCliente(@RequestBody Cliente cliente, UriComponentsBuilder builder) {
        clienteService.inserirCliente(cliente);
        
        URI location = builder.path("clientes/{numeroCnh}").buildAndExpand(cliente.getNumeroCnh()).toUri();        
        return ResponseEntity.created(location).body(cliente);       
    }

    @GetMapping("/{numeroCnh}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable long numeroCnh) {
        return ResponseEntity.ok().body(clienteService.encontrarCliente(numeroCnh));
    }

    @PutMapping("/{numeroCnh}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable long numeroCnh, @RequestBody AtualizaClienteDTO dto) {
        return ResponseEntity.ok().body(clienteService.alterarCliente(dto, numeroCnh));
    }

    @DeleteMapping("/{numeroCnh}")
    public ResponseEntity deletarCliente(@PathVariable long numeroCnh) {
        return ResponseEntity.noContent().build();
    }
}