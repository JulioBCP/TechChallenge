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

import com.fiap.techchallenge.carrental.DTO.AtualizaReservaDTO;
import com.fiap.techchallenge.carrental.entity.Reserva;
import com.fiap.techchallenge.carrental.service.CadastroReservaService;

@RestController
@RequestMapping(value="/Reservas")
public class ReservaController {
    
    @Autowired
    CadastroReservaService reservaService;

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
    public ResponseEntity<Reserva> deletarReserva(@PathVariable long id) {
        return ResponseEntity.noContent().build();
    }
}