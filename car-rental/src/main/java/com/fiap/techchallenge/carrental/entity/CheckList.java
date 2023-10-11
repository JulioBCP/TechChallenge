package com.fiap.techchallenge.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CheckList {

   private String nivelCombustivel;
   private int pressaoPneus;
   private String avariasPintura;
   private String avariasInterna;
   private String limpeza;
   private int km;
   private Contrato contrato;
   private TipoCheckListEnum tipoCheckList;

}
