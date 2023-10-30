package com.fiap.techchallenge.carrental.pagamento.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ItemPedidoDTO {
    
    @JsonProperty("name")
    private String nome;

    @JsonProperty("unit_amount")
    private long valor;

    @JsonProperty("quantity")
    private int quantidade;

}
