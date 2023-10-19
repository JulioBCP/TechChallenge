package com.fiap.techchallenge.carrental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.techchallenge.carrental.DTO.AtualizaReservaDTO;
import com.fiap.techchallenge.carrental.entity.Reserva;
import com.fiap.techchallenge.carrental.repository.ReservaRepository;

@Service
public class CadastroReservaService {

    //TODO
    @Autowired
    ReservaRepository reservaRepository;

    //creat
    public Reserva inserirReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    //read
    public Reserva encontrarReserva(long id) {
        return reservaRepository.getReferenceById(id);
    } 

    //update
    public Reserva alterarReserva(AtualizaReservaDTO atualizaReserva, long id) {
        Reserva reserva = reservaRepository.getReferenceById(id);

        return reservaRepository.save(reserva);  
    }

    //delete
    public void deletarReserva(long numeroApolice) {
        reservaRepository.deleteById(numeroApolice);
    }
}