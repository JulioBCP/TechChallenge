package com.fiap.techchallenge.carrental.pagamento.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CartaoPagamentoDTO {
    
    @JsonProperty("number")
    private String numero;

    @JsonProperty("exp_month")
    private int mesVencimento;

    @JsonProperty("exp_year")
    private int anoVencimento;

    @JsonProperty("security_code")
    private String ccv;

}
