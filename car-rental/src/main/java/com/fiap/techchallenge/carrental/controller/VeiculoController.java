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
import org.springframework.web.util.UriComponentsBuilder;

import com.fiap.techchallenge.carrental.DTO.AtualizaVeiculoDTO;
import com.fiap.techchallenge.carrental.entity.Veiculo;
import com.fiap.techchallenge.carrental.service.CadastroVeiculoService;

@RestController
@RequestMapping(value="/Veiculos")
public class VeiculoController {
    
    @Autowired
    CadastroVeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Veiculo> inserirVeiculo(@RequestBody Veiculo veiculo, UriComponentsBuilder builder) {
        veiculoService.inserirVeiculo(veiculo);
        
        URI location = builder.path("Veiculos/{id}").buildAndExpand(veiculo.getId()).toUri();        
        return ResponseEntity.created(location).body(veiculo);       
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarVeiculo(@PathVariable long id) {
        return ResponseEntity.ok().body(veiculoService.encontrarVeiculo(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable long id, @RequestBody AtualizaVeiculoDTO dto) {
        return ResponseEntity.ok().body(veiculoService.alterarVeiculo(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Veiculo> deletarVeiculo(@PathVariable long id) {
        return ResponseEntity.noContent().build();
    }
}