package com.fiap.techchallenge.carrental.aluguel.entity.enumerations;

import lombok.Getter;

@Getter
public enum ValoresDiariasModeloEnum {
    
    DIARIA_SEDAN(35.00),
    DIARIA_HATCH(45.00),
    DIARIA_PICKUP(70.00),
    DIARIA_UTILITARIO(85.00),
    DIARIA_SUV( 100.00),
    DIARIA_ESPORTIVO(120.00);

    private double valorDiaria;

    ValoresDiariasModeloEnum(double valorDiaria){
        this.valorDiaria = valorDiaria;
    }

}
