package com.fiap.techchallenge.carrental.entity;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContratoCalculator {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ContratoCalculator.class);
    private static final double IMPOSTO = 1.15; //valor do imposto de 15%

    public static double calculoValorContrato(LocalDate dataInicio, LocalDate dataFim, TipoVeiculoEnum tipoVeiculo){
        double valorContrato;
        DecimalFormat formato = new DecimalFormat("#.##");      
        final long diarias = ChronoUnit.DAYS.between(dataInicio, dataFim);

        switch(tipoVeiculo) {
            case SEDAN:
                valorContrato = ValoresDiariasModeloEnum.DIARIA_SEDAN.getValorDiaria()*diarias*IMPOSTO;
                LOGGER.info("SEDAN - diarias {} valorContrato {} ", diarias, valorContrato);
                break;
            case HATCH:
                valorContrato = ValoresDiariasModeloEnum.DIARIA_HATCH.getValorDiaria()*diarias*IMPOSTO;
                LOGGER.info("HATCH - diarias {} valorContrato {} ", diarias, valorContrato);
                break;
            case PICKUP:
                valorContrato = ValoresDiariasModeloEnum.DIARIA_PICKUP.getValorDiaria()*diarias*IMPOSTO;
                LOGGER.info("PICKUP - diarias {} valorContrato {} ", diarias, valorContrato);
                break;
            case UTILITARIO:
                valorContrato = ValoresDiariasModeloEnum.DIARIA_UTILITARIO.getValorDiaria()*diarias*IMPOSTO;
                LOGGER.info("UTILITARIO - diarias {} valorContrato {} ", diarias, valorContrato);                
                break;
            case SUV:
                valorContrato = ValoresDiariasModeloEnum.DIARIA_SUV.getValorDiaria()*diarias*IMPOSTO;
                LOGGER.info("SUV - diarias {} valorContrato {} ", diarias, valorContrato);
                break;
            case ESPORTIVO:
                valorContrato = ValoresDiariasModeloEnum.DIARIA_ESPORTIVO.getValorDiaria()*diarias*IMPOSTO;
                LOGGER.info("ESPORTIVO - diarias {} valorContrato {} ", diarias, valorContrato);
                break;
            default:
                valorContrato = 0.00;
                LOGGER.info(" Sem cálculo | valorContrato {} ", valorContrato);
                break;
        }
        
        return Double.valueOf(formato.format(valorContrato));
               
    }
}
