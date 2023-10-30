package com.fiap.techchallenge.carrental.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.techchallenge.carrental.DTO.AtualizaReservaDTO;
import com.fiap.techchallenge.carrental.entity.Cliente;
import com.fiap.techchallenge.carrental.entity.ContratoCalculator;
import com.fiap.techchallenge.carrental.entity.Reserva;
import com.fiap.techchallenge.carrental.entity.Veiculo;
import com.fiap.techchallenge.carrental.exceptions.ClienteException;
import com.fiap.techchallenge.carrental.exceptions.VeiculoException;
import com.fiap.techchallenge.carrental.repository.ClienteRepository;
import com.fiap.techchallenge.carrental.repository.ReservaRepository;
import com.fiap.techchallenge.carrental.repository.VeiculoRepository;

@Service
public class CadastroReservaService {

    @Autowired
    ReservaRepository reservaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    VeiculoRepository veiculoRepository;

    // creat
    public Reserva inserirReserva(Reserva reserva) {
        Cliente cliente = clienteRepository.findById(reserva.getCliente().getNumeroCnh()).orElseThrow(() -> new ClienteException("Cliente não cadastrado!"));
        Veiculo veiculo = veiculoRepository.findById(reserva.getVeiculo().getId()).orElseThrow(() -> new VeiculoException("Veículo não cadastrado!"));

        reserva.setCliente(cliente);
        reserva.setVeiculo(veiculo);
        reserva.setValorReserva(ContratoCalculator.calculoValorContrato(reserva.getDataInicio(), reserva.getDataFim(), reserva.getVeiculo().getTipoVeiculo()));
        reserva.verificarSeExisteReserva(reservaRepository.findAll());

        return reservaRepository.save(reserva);
    }

    // read
    public Reserva encontrarReserva(long id) {
        return reservaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Reserva não encontrada!"));
    }

    // update
    public Reserva alterarReserva(AtualizaReservaDTO atualizaReserva, long id) {
        Reserva reserva = reservaRepository.getReferenceById(id);
        reserva.setVeiculo(atualizaReserva.veiculo());
        reserva.setValorReserva(atualizaReserva.valorContrato());
        reserva.setDataInicio(atualizaReserva.dataInicio());
        reserva.setDataFim(atualizaReserva.dataFim());

        return reservaRepository.save(reserva);
    }

    // delete
    public void deletarReserva(long id) {
        reservaRepository.findById(id).orElseThrow();
        
        reservaRepository.deleteById(id);
    }
}