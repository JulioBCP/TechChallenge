package com.fiap.techchallenge.carrental.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.techchallenge.carrental.cliente.DTO.AtualizarClienteDTO;
import com.fiap.techchallenge.carrental.cliente.entity.Cliente;
import com.fiap.techchallenge.carrental.cliente.repository.ClienteRepository;

@Service
public class CadastroClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    //creat
    public Cliente inserirCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    //read
    public Cliente encontrarCliente(long numeroCnh) {
        return clienteRepository.getReferenceById(numeroCnh);
    } 

    //update
    public Cliente alterarCliente(AtualizarClienteDTO atualizaCliente, long numeroCnh) {
        Cliente cliente = clienteRepository.getReferenceById(numeroCnh);
        cliente.getUsuario().setNome(atualizaCliente.nome());
        cliente.setEndereco(atualizaCliente.endereco());

        return clienteRepository.save(cliente);
    }

    //delete
    public void deletarCliente(long numeroCnh) {
        clienteRepository.deleteById(numeroCnh);
    }
}