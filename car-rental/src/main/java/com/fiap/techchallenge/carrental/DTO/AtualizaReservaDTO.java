package com.fiap.techchallenge.carrental.DTO;

import java.time.LocalDate;
import com.fiap.techchallenge.carrental.entity.Veiculo;

public record AtualizaReservaDTO(Veiculo veiculo, Double valorContrato, LocalDate dataInicio, LocalDate dataFim) {
    
}
