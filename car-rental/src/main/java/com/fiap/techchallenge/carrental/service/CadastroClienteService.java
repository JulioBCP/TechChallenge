package com.fiap.techchallenge.carrental.service;

@Service
public class CadastroClienteService {

    //TODO
    @Autowired
    ClienteRepository clienteRepository;

    //creat
    public Cliente inserirCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        //TODO retornar um log com status - ok/nok
        return cliente;
    }

    //read
    public Cliente encontrarCliente(long numeroCnh) {
        clienteRepository.getReferenceById(numeroCnh);
        //TODO retornar um log com status - ok/nok
        return cliente;
    } 

    // //update

    // //delete
}