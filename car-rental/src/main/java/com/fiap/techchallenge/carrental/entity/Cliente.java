package com.fiap.techchallenge.carrental.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Usuario {

   private int numeroCnh;
   private LocalDate dataNascimento;
   private String sexo;
   private int CPF;
   private Endereco endereco;
   private int telefone;

}
