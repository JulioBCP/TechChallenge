package com.fiap.techchallenge.carrental.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Veiculo {

   private TipoVeiculoEnum tipoVeiculo;
   private MarcaEnum marca;
   private String modelo;
   private int anomodelo;
   private int anoFabricacao;
   private String motor;
   private String cor;
   private String tracao;
   private boolean arCondicionado;
   private boolean trioEletrico;
   private boolean tetoSolar;
   private CombustivelEnum combustivel;
   private boolean cabineDupla;
   private String capacidadeCarga;

}
