package com.fiap.techchallenge.carrental.entity;

import java.time.format.DateTimeFormatter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name = "contrato")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Contrato {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Enumerated(EnumType.STRING)
   private FormaDePagamentoEnum formaPagamento;

   private Double multaDiaria;

   @OneToOne
   private Reserva reserva;

  @Column
   private String token;

   public void geradorToken(Reserva reserva) {
      if(reserva == null)
         return;

      final String nomeCliente = reserva.getCliente().getUsuario().getLogin().toUpperCase(); 
      final String veiculo = reserva.getVeiculo().getModelo().toUpperCase();

      DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM");

      final String dataIni = reserva.getDataInicio().format(formato);
      final String dataFim = reserva.getDataFim().format(formato);
      
      final String div = "#"; 
      //NOME#VEICULO#00/00#00/00
      setToken(nomeCliente+div+veiculo+div+dataIni+div+dataFim);
   }
}
