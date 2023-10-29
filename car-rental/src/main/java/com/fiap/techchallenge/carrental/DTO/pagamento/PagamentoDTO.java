package com.fiap.techchallenge.carrental.DTO.pagamento;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PagamentoDTO {
    
    @JsonProperty("amount")
    private MontantePagamentoDTO montante;

    @JsonProperty("payment_method")
    private MetodoPagamentoDTO metodoPagamento;
}
