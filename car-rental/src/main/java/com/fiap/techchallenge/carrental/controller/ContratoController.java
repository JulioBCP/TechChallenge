package com.fiap.techchallenge.carrental.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiap.techchallenge.carrental.DTO.CartaoClienteDTO;
import com.fiap.techchallenge.carrental.entity.Cliente;
import com.fiap.techchallenge.carrental.entity.Contrato;
import com.fiap.techchallenge.carrental.entity.MarcaEnum;
import com.fiap.techchallenge.carrental.entity.Usuario;
import com.fiap.techchallenge.carrental.entity.Veiculo;
import com.fiap.techchallenge.carrental.pagamento.entity.Pagamento;
import com.fiap.techchallenge.carrental.pagamento.entity.enumarations.StatusPagamentoEnum;
import com.fiap.techchallenge.carrental.pagamento.service.PagamentoService;
import com.fiap.techchallenge.carrental.service.CadastroContratoService;

@RestController
@RequestMapping(value = "/contratos")
public class ContratoController {

    @Autowired
    private CadastroContratoService contratoService;

    @Autowired
    private PagamentoService pagamentoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ContratoController.class);

    @PostMapping
    public ResponseEntity<Contrato> inserirContrato(@RequestBody Contrato Contrato, UriComponentsBuilder builder) {
        contratoService.inserirContrato(Contrato);

        URI location = builder.path("Contratos/{id}").buildAndExpand(Contrato.getId()).toUri();
        return ResponseEntity.created(location).body(Contrato);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> buscarContrato(@PathVariable long id) {
        return ResponseEntity.ok().body(contratoService.encontrarContrato(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarContrato(@PathVariable long id) {
        try {
            contratoService.deletarContrato(id);
            LOGGER.info("Contrato {} eliminado com sucesso!", id);
        } catch (Exception e) {
            LOGGER.error("Não foi possível eliminar o contrato {}!", id);
            return new ResponseEntity<>("Não foi possível eliminar o contrato!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Contrato eliminado com sucesso!", HttpStatus.OK);
    }

    @PostMapping("/{id}/pagamentos/")
    public ResponseEntity<Contrato> efetuarPagamento(@PathVariable long id, @RequestBody CartaoClienteDTO cartaoCliente) {
        Contrato contrato = contratoService.efetuarPagamento(id, cartaoCliente);

        Pagamento pagamento = contrato.getPagamento();
        if(pagamento.getStatus().equals(StatusPagamentoEnum.PAGO)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("teste")
    public String teste(){
        Usuario usuario = new Usuario();
        usuario.setNome("Thomas Germanos Dantas");
        Cliente cliente = new Cliente();
        cliente.setCPF(91583818057l);
        cliente.setEmail("thomasgermanos@gmail.com");
        cliente.setUsuario(usuario);

        Veiculo veiculo = new Veiculo();
        veiculo.setAnoFabricacao(2012);
        veiculo.setAnomodelo(2013);
        veiculo.setMarca(MarcaEnum.FIAT);
        veiculo.setModelo("Sienna");
        
        CartaoClienteDTO cartaoCliente = new CartaoClienteDTO();
        cartaoCliente.setCcv("112");
        cartaoCliente.setNumero("5567462609791245");
        cartaoCliente.setAnoVencimento(2025);
        cartaoCliente.setMesVencimento(12);

        double valorPagamento = 123.22;

        ResponseEntity<String> response = pagamentoService.efetuarPagamento(cliente, veiculo, cartaoCliente, valorPagamento);
        return response.getBody();
    }
}