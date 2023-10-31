package com.fiap.techchallenge.carrental.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.techchallenge.carrental.aluguel.DTO.AtualizarVeiculoDTO;
import com.fiap.techchallenge.carrental.aluguel.entity.Veiculo;
import com.fiap.techchallenge.carrental.aluguel.repository.VeiculoRepository;

@Service
public class CadastroVeiculoService {

    @Autowired
    VeiculoRepository veiculoRepository;

    //creat
    public Veiculo inserirVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    //read
    public Veiculo encontrarVeiculo(long id) {
        return veiculoRepository.getReferenceById(id);
    } 

    //update
    public Veiculo alterarVeiculo(AtualizarVeiculoDTO atualizaVeiculo, long id) {
        Veiculo veiculo = veiculoRepository.getReferenceById(id);
        veiculo.setKm(atualizaVeiculo.km());
        veiculo.setKmManutencao(atualizaVeiculo.kmManutencao());

        return veiculoRepository.save(veiculo);
    }

    //delete
    public void deletarVeiculo(long id) {
        veiculoRepository.deleteById(id);
    }
}