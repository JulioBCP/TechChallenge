package com.fiap.techchallenge.carrental.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "cliente")
public class Cliente {

   @Id
   @Column(unique = true)
   private long numeroCnh;

   @Column(nullable = false)
   private LocalDate dataNascimento;

   @Enumerated(EnumType.STRING)
   private SexoEnum sexo;   

   @Column(nullable = false, unique = true)
   private int CPF;

   @Column(nullable = false)
   private int telefone;   

   @Embedded
   private Endereco endereco;

   @Embedded
   private Usuario usuario;   

}
