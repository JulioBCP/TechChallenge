package com.fiap.techchallenge.carrental.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.techchallenge.carrental.DTO.CartaoClienteDTO;
import com.fiap.techchallenge.carrental.entity.Cliente;
import com.fiap.techchallenge.carrental.entity.Contrato;
import com.fiap.techchallenge.carrental.entity.ContratoCalculator;
import com.fiap.techchallenge.carrental.entity.Reserva;
import com.fiap.techchallenge.carrental.entity.Veiculo;
import com.fiap.techchallenge.carrental.pagamento.entity.Pagamento;
import com.fiap.techchallenge.carrental.pagamento.entity.enumarations.StatusPagamento;
import com.fiap.techchallenge.carrental.pagamento.service.PagamentoService;
import com.fiap.techchallenge.carrental.repository.ContratoRepository;

@Service
public class CadastroContratoService {

    @Autowired
    private ContratoRepository contratoRepository;
    
    @Autowired
    private PagamentoService pagamentoService; 

    public Contrato inserirContrato(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    public Contrato encontrarContrato(long id) {
        return contratoRepository.getReferenceById(id);
    } 

    public void deletarContrato(long id) {
        contratoRepository.deleteById(id);
    }
    
    public Contrato efetuarPagamento(long contratoId, CartaoClienteDTO cartaoCliente){
        Contrato contrato = contratoRepository.findById(contratoId).get();
        Reserva reserva = contrato.getReserva();
        Cliente cliente = reserva.getCliente();
        Veiculo veiculo = reserva.getVeiculo();
        double valorPagamento = ContratoCalculator.calculoValorContrato(reserva.getDataInicio(), reserva.getDataFim(), veiculo.getTipoVeiculo());
        
        if(contrato.getPagamento() == null) {
            contrato.setPagamento(criarPagamento());
        }
        
        //garantir que sempre vai ter o valor atualizado
        contrato.getPagamento().setValor(valorPagamento);
        contratoRepository.save(contrato);
        
        ResponseEntity<String> response = pagamentoService.efetuarPagamento(cliente, veiculo, cartaoCliente, valorPagamento);

        if(response.getStatusCode().equals(HttpStatus.CREATED)) {
            contrato.getPagamento().setStatus(StatusPagamento.PAGO);
            contrato.getPagamento().setDataPagamento(LocalDate.now());
            try {
                contrato.getPagamento().setOrderId(extrairOrderIdRequest(response));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        return contratoRepository.save(contrato);
    }

    private Pagamento criarPagamento() {
        Pagamento pagamento = new Pagamento();
        pagamento.setStatus(StatusPagamento.PENDENTE);
        

        return pagamento;
    }

    private String extrairOrderIdRequest(HttpEntity<String> response) throws JsonMappingException, JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode orderId = root.path("id");
        return orderId.asText();
    }
}