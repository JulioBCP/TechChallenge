package com.fiap.techchallenge.carrental.entity;

import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Setter

@Entity
@Table(name = "contrato")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Contrato {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long numeroApolice;

   @Enumerated(EnumType.STRING)
   private FormaDePagamentoEnum formaPagamento;

   private Double multaDiaria;

   @OneToOne
   private Reserva reserva;

}
