package com.fiap.techchallenge.carrental.DTO.pagamento;

import java.util.List;

import com.fiap.techchallenge.carrental.DTO.CartaoClienteDTO;
import com.fiap.techchallenge.carrental.entity.Cliente;
import com.fiap.techchallenge.carrental.entity.Veiculo;

public class PedidoDTOBuilder {
    
    public static PedidoDTO build(Cliente cliente, Veiculo veiculo, CartaoClienteDTO cartaoClienteDTO, double valorPagamento){

        Long valorItem = (long) (valorPagamento * 100);
        
        ClientePedidoDTO clienteDTO = ClientePedidoDTO.builder()
            .nome(cliente.getUsuario().getNome())
            .cpf(Long.toString(cliente.getCPF()))
            .email(cliente.getEmail())
        .build();

        ItemPedidoDTO itemPedidoDTO = ItemPedidoDTO.builder()
            .nome("ALUGUEL " +veiculo.getMarca() +" " +veiculo.getModelo() +" (" +veiculo.getAnoFabricacao() +"/" +veiculo.getAnomodelo() +")")
            .valor(valorItem)
            .quantidade(1)
        .build();

        CartaoPagamentoDTO cartaoPagamentoDTO = CartaoPagamentoDTO.builder()
            .numero(cartaoClienteDTO.getNumero())
            .mesVencimento(cartaoClienteDTO.getMesVencimento())
            .anoVencimento(cartaoClienteDTO.getAnoVencimento())
            .ccv(cartaoClienteDTO.getCcv())
        .build();

        MetodoPagamentoDTO metodoPagamentoDTO = MetodoPagamentoDTO.builder()
            .cartao(cartaoPagamentoDTO)
            .capture(true)
            .parcelas(1)
            .tipo("CREDIT_CARD")
        .build();
            
        PagamentoDTO pagamentoDTO = PagamentoDTO.builder()
            .metodoPagamento(metodoPagamentoDTO)
            .montante(MontantePagamentoDTO.builder().moeda("BRL").valor(valorItem).build())
        .build();

        PedidoDTO pedidoPagamento = PedidoDTO.builder()
            .cliente(clienteDTO)
            .itens(List.of(itemPedidoDTO))
            .pagamentos(List.of(pagamentoDTO))
            .build();

        return pedidoPagamento;
    }
}
