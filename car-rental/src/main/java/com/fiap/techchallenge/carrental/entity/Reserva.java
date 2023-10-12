package com.fiap.techchallenge.carrental.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter

@Entity
@Table(name = "reserva")
public class Reserva {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;    

    @OneToOne
    private Cliente cliente;

    @OneToOne
    private Veiculo veiculo;

    @Column(nullable = false)
    private Double valorContrato;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataFim;

}
