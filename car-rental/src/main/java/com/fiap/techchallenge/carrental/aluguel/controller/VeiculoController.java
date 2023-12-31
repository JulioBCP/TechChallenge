package com.fiap.techchallenge.carrental.aluguel.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.fiap.techchallenge.carrental.aluguel.DTO.AtualizarVeiculoDTO;
import com.fiap.techchallenge.carrental.aluguel.entity.Veiculo;
import com.fiap.techchallenge.carrental.aluguel.service.CadastroVeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

    @Autowired
    CadastroVeiculoService veiculoService;
    private static final Logger LOGGER = LoggerFactory.getLogger(VeiculoController.class);

    @PostMapping
    public ResponseEntity<Veiculo> inserirVeiculo(@RequestBody Veiculo veiculo, UriComponentsBuilder builder) {
        veiculoService.inserirVeiculo(veiculo);

        URI location = builder.path("veiculos/{id}").buildAndExpand(veiculo.getId()).toUri();
        LOGGER.info("Veiculo de id {} cadastrado com sucesso!", veiculo.getId());

        return ResponseEntity.created(location).body(veiculo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarVeiculo(@PathVariable long id) {
        return ResponseEntity.ok().body(veiculoService.encontrarVeiculo(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable long id, @RequestBody AtualizarVeiculoDTO dto) {

        LOGGER.info("Veiculo de id {} alterado com sucesso!", id);
        return ResponseEntity.ok().body(veiculoService.alterarVeiculo(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarVeiculo(@PathVariable long id) {
        try {
            veiculoService.deletarVeiculo(id);
            LOGGER.info("Veículo {} eliminado com sucesso!", id);
        } catch (Exception e) {
            LOGGER.error("Não foi possível eliminar o veículo {}!", id);
            return new ResponseEntity<>("Não foi possível eliminar o veículo!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Veículo eliminado com sucesso!", HttpStatus.OK);
    }
}