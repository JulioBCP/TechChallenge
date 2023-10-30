package com.fiap.techchallenge.carrental.pagamento.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class MontantePagamentoDTO {
    
    @JsonProperty("value")
    private long valor;

    @JsonProperty("currency")
    private String moeda;
}
