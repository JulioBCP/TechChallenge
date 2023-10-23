package com.fiap.techchallenge.carrental.entity;

import com.fiap.techchallenge.carrental.entity.ValoresDiariasModeloEnum;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ContratoCalculator {
    
    private static final double IMPOSTO = 0.15;

    public double calculoValorContrato(LocalDate dataInicio, 
        LocalDate dataFim, TipoVeiculoEnum tipoVeiculo)
    {
        double valorContrato;
        final long diarias = ChronoUnit.DAYS.between(dataInicio, dataFim);

        switch(tipoVeiculo) {
            case SEDAN:
                valorContrato = ValoresDiariasModeloEnum.DIARIA_SEDAN.getValorDiaria()*diarias*IMPOSTO;
                break;
            case HATCH:
                valorContrato = ValoresDiariasModeloEnum.DIARIA_HATCH.getValorDiaria()*diarias*IMPOSTO;
                break;
            case PICKUP:
                valorContrato = ValoresDiariasModeloEnum.DIARIA_PICKUP.getValorDiaria()*diarias*IMPOSTO;
                break;
            case UTILITARIO:
                valorContrato = ValoresDiariasModeloEnum.DIARIA_UTILITARIO.getValorDiaria()*diarias*IMPOSTO;
                break;
            case SUV:
                valorContrato = ValoresDiariasModeloEnum.DIARIA_SUV.getValorDiaria()*diarias*IMPOSTO;
                break;
            case ESPORTIVO:
                valorContrato = ValoresDiariasModeloEnum.DIARIA_ESPORTIVO.getValorDiaria()*diarias*IMPOSTO;
                break;
            default:
                valorContrato = 0.00;
                break;

        }
        return valorContrato;
    }
}
