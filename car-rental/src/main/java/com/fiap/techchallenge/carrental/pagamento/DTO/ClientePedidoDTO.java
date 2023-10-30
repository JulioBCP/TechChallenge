package com.fiap.techchallenge.carrental.pagamento.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientePedidoDTO {
    
    @JsonProperty("name")
    private String nome;

    @JsonProperty("email")
    private String email;

    @JsonProperty("tax_id")
    private String cpf;
}
