package com.fiap.techchallenge.carrental.pagamento.entity;

import java.time.LocalDate;

import com.fiap.techchallenge.carrental.pagamento.entity.enumarations.StatusPagamentoEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "pagamento")
public class Pagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private double valor;
    
    private LocalDate dataPagamento;

    private String orderId;
    
    private StatusPagamentoEnum status;

}
