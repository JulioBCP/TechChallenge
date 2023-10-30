package com.fiap.techchallenge.carrental.pagamento.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiap.techchallenge.carrental.DTO.CartaoClienteDTO;
import com.fiap.techchallenge.carrental.entity.Cliente;
import com.fiap.techchallenge.carrental.entity.Veiculo;
import com.fiap.techchallenge.carrental.pagamento.DTO.PedidoDTO;
import com.fiap.techchallenge.carrental.pagamento.DTO.PedidoDTOBuilder;

@Service
public class PagamentoService {

    private RestTemplate restTemplate = new RestTemplate();

    @Value( "${pagamento.gateway.urlBase}")
    private String baseUrl;

    @Value( "${pagamento.gateway.token}")
    private String token;

    public ResponseEntity<String> efetuarPagamento(Cliente cliente, Veiculo veiculo, CartaoClienteDTO cartaoClienteDTO, double valorPagamento){

        PedidoDTO pedidoPagamento = PedidoDTOBuilder.build(cliente, veiculo, cartaoClienteDTO, valorPagamento);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "Bearer "+token);

        URI uri = UriComponentsBuilder.fromUriString(baseUrl + "/orders").build().toUri();

        RequestEntity<PedidoDTO> requestEntity = RequestEntity.post(uri)
        .headers(httpHeaders)
        .body(pedidoPagamento, getClass());
        
        return restTemplate.exchange(requestEntity, String.class);

    }

}