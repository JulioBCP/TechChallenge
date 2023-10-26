package com.fiap.techchallenge.carrental.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiap.techchallenge.carrental.entity.Contrato;
import com.fiap.techchallenge.carrental.service.CadastroContratoService;

@RestController
@RequestMapping(value = "/Contratos")
public class ContratoController {

    @Autowired
    CadastroContratoService contratoService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ContratoController.class);

    @PostMapping
    public ResponseEntity<Contrato> inserirContrato(@RequestBody Contrato Contrato, UriComponentsBuilder builder) {
        contratoService.inserirContrato(Contrato);

        URI location = builder.path("Contratos/{id}").buildAndExpand(Contrato.getId()).toUri();
        return ResponseEntity.created(location).body(Contrato);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> buscarContrato(@PathVariable long id) {
        return ResponseEntity.ok().body(contratoService.encontrarContrato(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarContrato(@PathVariable long id) {
        try {
            contratoService.deletarContrato(id);
            LOGGER.info("Contrato {} eliminado com sucesso!", id);
        } catch (Exception e) {
            LOGGER.error("Não foi possível eliminar o contrato {}!", id);
            return new ResponseEntity<>("Não foi possível eliminar o contrato!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Contrato eliminado com sucesso!", HttpStatus.OK);
    }
}