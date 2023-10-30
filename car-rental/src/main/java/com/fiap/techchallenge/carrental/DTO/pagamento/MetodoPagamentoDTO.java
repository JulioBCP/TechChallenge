package com.fiap.techchallenge.carrental.DTO.pagamento;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MetodoPagamentoDTO {
    
    @JsonProperty("card")
    private CartaoPagamentoDTO cartao;

    @JsonProperty("type")
    private String tipo;

    @JsonProperty("installments")
    private int parcelas;

    @JsonProperty("capture")
    private boolean capture;

}
