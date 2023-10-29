package com.fiap.techchallenge.carrental.DTO.pagamento;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidoDTO {
    
    @JsonProperty("custumer")
    private ClientePedidoDTO cliente;

    @JsonProperty("charges")
    private List<PagamentoDTO> pagamentos;

    @JsonProperty("items")
    private List<ItemPedidoDTO> itens;

}
