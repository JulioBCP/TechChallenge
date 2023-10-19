package com.fiap.techchallenge.carrental.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiap.techchallenge.carrental.entity.Contrato;
import com.fiap.techchallenge.carrental.service.CadastroContratoService;

@RestController
@RequestMapping(value="/Contratos")
public class ContratoController {
    
    @Autowired
    CadastroContratoService ContratoService;

    @PostMapping
    public ResponseEntity<Contrato> inserirContrato(@RequestBody Contrato Contrato, UriComponentsBuilder builder) {
        ContratoService.inserirContrato(Contrato);
        
        URI location = builder.path("Contratos/{numeroApolice}").buildAndExpand(Contrato.getNumeroApolice()).toUri();        
        return ResponseEntity.created(location).body(Contrato);       
    }

    @GetMapping("/{numeroApolice}")
    public ResponseEntity<Contrato> buscarContrato(@PathVariable long numeroApolice) {
        return ResponseEntity.ok().body(ContratoService.encontrarContrato(numeroApolice));
    }

    // @PutMapping("/{numeroApolice}")
    // public ResponseEntity<Contrato> atualizarContrato(@PathVariable long numeroApolice, @RequestBody AtualizaContratoDTO dto) {
    //     return ResponseEntity.ok().body(ContratoService.alterarContrato(dto, numeroApolice));
    // }

    @DeleteMapping("/{numeroApolice}")
    public ResponseEntity<Contrato> deletarContrato(@PathVariable long numeroApolice) {
        return ResponseEntity.noContent().build();
    }
}