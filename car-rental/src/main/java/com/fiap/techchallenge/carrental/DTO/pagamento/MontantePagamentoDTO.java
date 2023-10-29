package com.fiap.techchallenge.carrental.DTO.pagamento;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MontantePagamentoDTO {
    
    @JsonProperty("value")
    private double valor;

    @JsonProperty("currency")
    private String moeda;
}
