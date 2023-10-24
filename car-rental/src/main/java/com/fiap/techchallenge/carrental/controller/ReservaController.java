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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiap.techchallenge.carrental.DTO.AtualizaReservaDTO;
import com.fiap.techchallenge.carrental.entity.Reserva;
import com.fiap.techchallenge.carrental.service.CadastroReservaService;

@RestController
@RequestMapping(value = "/Reservas")
public class ReservaController {

    @Autowired
    CadastroReservaService reservaService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservaController.class);

    @PostMapping
    public ResponseEntity<Reserva> inserirReserva(@RequestBody Reserva reserva, UriComponentsBuilder builder) {
        reservaService.inserirReserva(reserva);

        URI location = builder.path("Reservas/{id}").buildAndExpand(reserva.getId()).toUri();
        return ResponseEntity.created(location).body(reserva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarReserva(@PathVariable long id) {
        return ResponseEntity.ok().body(reservaService.encontrarReserva(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizarReserva(@PathVariable long id, @RequestBody AtualizaReservaDTO dto) {
        return ResponseEntity.ok().body(reservaService.alterarReserva(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarReserva(@PathVariable long id) {
        try {
            reservaService.deletarReserva(id);
            LOGGER.info("Reserva {} eliminada com sucesso!", id);
        } catch (Exception e) {
            LOGGER.error("Não foi possível eliminar a reserva {}!", id);
            return new ResponseEntity<>("Não foi possível eliminar a reserva!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Reserva eliminada com sucesso!", HttpStatus.ACCEPTED);
    }
}