package com.fiap.techchallenge.carrental.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {

   private String rua;
   private int numero;
   private String bairro;
   private String cidade;
   private String estado;
   private String pais;
   private int cep;

}
