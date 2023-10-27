package com.fiap.techchallenge.carrental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.techchallenge.carrental.entity.Contrato;
import com.fiap.techchallenge.carrental.repository.ContratoRepository;

@Service
public class CadastroContratoService {

    @Autowired
    ContratoRepository contratoRepository;

    //creat
    public Contrato inserirContrato(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    //read
    public Contrato encontrarContrato(long id) {
        return contratoRepository.getReferenceById(id);
    } 

    //delete
    public void deletarContrato(long id) {
        contratoRepository.deleteById(id);
    }
}