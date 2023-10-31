package com.fiap.techchallenge.carrental.aluguel.DTO;

import java.time.LocalDate;

import com.fiap.techchallenge.carrental.aluguel.entity.Veiculo;

public record AtualizarReservaDTO(Veiculo veiculo, Double valorContrato, LocalDate dataInicio, LocalDate dataFim) {
    
}
