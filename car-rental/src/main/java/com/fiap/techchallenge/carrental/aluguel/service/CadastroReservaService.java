package com.fiap.techchallenge.carrental.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.techchallenge.carrental.aluguel.DTO.AtualizarReservaDTO;
import com.fiap.techchallenge.carrental.aluguel.entity.Reserva;
import com.fiap.techchallenge.carrental.aluguel.repository.ReservaRepository;

@Service
public class CadastroReservaService {

    @Autowired
    ReservaRepository reservaRepository;

    // creat
    public Reserva inserirReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // read
    public Reserva encontrarReserva(long id) {
        return reservaRepository.getReferenceById(id);
    }

    // update
    public Reserva alterarReserva(AtualizarReservaDTO atualizaReserva, long id) {
        Reserva reserva = reservaRepository.getReferenceById(id);
        reserva.setVeiculo(atualizaReserva.veiculo());
        reserva.setValorReserva(atualizaReserva.valorContrato());
        reserva.setDataInicio(atualizaReserva.dataInicio());
        reserva.setDataFim(atualizaReserva.dataFim());

        return reservaRepository.save(reserva);
    }

    // delete
    public void deletarReserva(long id) {
        reservaRepository.deleteById(id);
    }
}