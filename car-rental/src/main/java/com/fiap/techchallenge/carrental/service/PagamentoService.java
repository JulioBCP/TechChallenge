package com.fiap.techchallenge.carrental.service;

import java.net.URI;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiap.techchallenge.carrental.DTO.CartaoClienteDTO;
import com.fiap.techchallenge.carrental.DTO.pagamento.PedidoDTO;
import com.fiap.techchallenge.carrental.DTO.pagamento.PedidoDTOBuilder;
import com.fiap.techchallenge.carrental.entity.Cliente;
import com.fiap.techchallenge.carrental.entity.Veiculo;

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
        // return restTemplate.exchange(baseUrl + "/orders", HttpMethod.POST, new HttpEntity<String>(httpHeaders), pedidoPagamento, httpHeaders, String.class);
        // return restTemplate.postForEntity(baseUrl + "/orders", pedidoPagamento, String.class);


        URI uri = UriComponentsBuilder.fromUriString(baseUrl + "/orders").build().toUri();

        RequestEntity<PedidoDTO> requestEntity = RequestEntity.post(uri)
		.header("Authorization", "Bearer 432902D6300E49E6B559A386E179C14F")
        .header("Content-type", "application/json")
        .body(pedidoPagamento, getClass());
        
        System.out.println("valor item: " +requestEntity.getBody().getItens().get(0).getValor());
        ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);
        
        return response;

    }

}