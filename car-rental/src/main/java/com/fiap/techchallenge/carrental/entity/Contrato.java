package com.fiap.techchallenge.carrental.entity;

import java.time.LocalDate;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Contrato {

   private int numeroApolice;
   private Cliente cliente;
   private Veiculo veiculo;
   private LocalDate dataInicio;
   private LocalDate dataFim;
   private FormaDePagamentoEnum formaPagamento;
   private Double valorContrato;
   private Double multaDiaria;

}
