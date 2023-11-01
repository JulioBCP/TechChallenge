package com.fiap.techchallenge.carrental.aluguel.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fiap.techchallenge.carrental.aluguel.entity.enumerations.TipoCheckListEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "check_list")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CheckList {

   public static final int KMREVISAO = 10000;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @OneToOne
   private Contrato contrato;

   @Column(nullable = false)
   private boolean abastecido;

   @Column(nullable = false)
   private int pressaoPneus;

   @Column(nullable = false)
   private String avariasPintura;

   @Column(nullable = false)
   private String avariasInterna;

   @Column(nullable = false)
   private String limpeza;

   @Column(nullable = false)
   private int km;

   @Enumerated(EnumType.STRING)
   private TipoCheckListEnum tipoCheckList;

   public boolean fazerRevisao(int km) {
      return km > contrato.getReserva().getVeiculo().getKmManutencao() + KMREVISAO;
   }

}
