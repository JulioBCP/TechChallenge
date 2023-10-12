package com.fiap.techchallenge.carrental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "veiculo")
public class Veiculo {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   
   @Enumerated(EnumType.STRING)
   private TipoVeiculoEnum tipoVeiculo;

   @Enumerated(EnumType.STRING)
   private MarcaEnum marca;

   @Column(nullable = false)
   private String modelo;

   @Column(nullable = false)
   private int anomodelo;

   @Column(nullable = false)
   private int anoFabricacao;

   @Column(nullable = false)
   private int km;

   @Column(nullable = false)
   private int kmManutencao;

   @Column(nullable = false)
   private String motor;

   @Column(nullable = false)
   private String cor;

   @Enumerated(EnumType.STRING)
   private TracaoEnum tracao;   

   @Column(nullable = false)
   private boolean arCondicionado;

   @Column(nullable = false)
   private boolean trioEletrico;

   @Column(nullable = false)
   private boolean tetoSolar;

   @Enumerated(EnumType.STRING)
   private CombustivelEnum combustivel;

   @Column(nullable = false)
   private boolean cabineDupla;

   @Column(nullable = false)
   private String capacidadeCarga;

}

