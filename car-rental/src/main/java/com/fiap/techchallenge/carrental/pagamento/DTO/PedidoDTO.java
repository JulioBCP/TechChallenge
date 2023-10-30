package com.fiap.techchallenge.carrental.pagamento.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PedidoDTO {
    
    @JsonProperty("customer")
    private ClientePedidoDTO cliente;

    @JsonProperty("charges")
    private List<PagamentoDTO> pagamentos;

    @JsonProperty("items")
    private List<ItemPedidoDTO> itens;

}
