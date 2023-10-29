package com.fiap.techchallenge.carrental.DTO.pagamento;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemPedidoDTO {
    
    @JsonProperty("name")
    private String nome;

    @JsonProperty("quantity")
    private int quantidade;

    @JsonProperty("unit_amount")
    private double valor;
}
