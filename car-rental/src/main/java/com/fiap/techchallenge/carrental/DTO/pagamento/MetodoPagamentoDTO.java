package com.fiap.techchallenge.carrental.DTO.pagamento;

import com.fasterxml.jackson.annotation.JsonProperty;

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
