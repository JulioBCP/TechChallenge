package com.fiap.techchallenge.carrental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.techchallenge.carrental.entity.Contrato;
import com.fiap.techchallenge.carrental.repository.ContratoRepository;

@Service
public class CadastroContratoService {

    //TODO
    @Autowired
    ContratoRepository contratoRepository;

    //creat
    public Contrato inserirContrato(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    //read
    public Contrato encontrarContrato(long numeroApolice) {
        return contratoRepository.getReferenceById(numeroApolice);
    } 

    //update
    // public Contrato alterarContrato(AtualizaContratoDTO atualizaContrato, long numeroApolice) {
    //     Contrato Contrato = ContratoRepository.getReferenceById(numeroApolice);

    //     return ContratoRepository.save(Contrato);
    // }

    //delete
    public void deletarContrato(long numeroApolice) {
        contratoRepository.deleteById(numeroApolice);
    }
}