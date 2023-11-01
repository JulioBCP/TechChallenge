package com.fiap.techchallenge.carrental.pagamento.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PagamentoDTO {
    
    @JsonProperty("amount")
    private MontantePagamentoDTO montante;

    @JsonProperty("payment_method")
    private MetodoPagamentoDTO metodoPagamento;
}
