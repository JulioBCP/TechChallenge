package com.fiap.techchallenge.carrental.aluguel.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fiap.techchallenge.carrental.aluguel.entity.enumerations.TipoVeiculoEnum;
import com.fiap.techchallenge.carrental.aluguel.exceptions.CarRentalDateException;
import com.fiap.techchallenge.carrental.aluguel.exceptions.VeiculoException;
import com.fiap.techchallenge.carrental.aluguel.utils.ContratoCalculator;
import com.fiap.techchallenge.carrental.cliente.entity.Cliente;

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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Cliente cliente;

    @OneToOne
    private Veiculo veiculo;

    @Column(nullable = false)
    private Double valorReserva;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataFim;

    public double calcularValorReserva(LocalDate dataInicio, LocalDate dataFim, Veiculo veiculo)
            throws VeiculoException {
        // dataInicio não pode ser anterior à data de inicio da locação
        LocalDate hoje = LocalDate.now();
        TipoVeiculoEnum tipoVeiculo = veiculo.getTipoVeiculo();

        // as datas não podem ser nulas
        if (dataInicio == null || dataFim == null) {
            throw new CarRentalDateException("As duas datas deverão ser preenchidas");

        } else if (dataInicio.isBefore(hoje)) {
            throw new CarRentalDateException("A data inicial não poderá ser maior que a data de hoje");
            // o tipo de veiculo deverá vir preenchido
        } else if (tipoVeiculo == null) {
            throw new VeiculoException("o tipo do veiculo não pode ser vazio");

        } else {
            return ContratoCalculator.calcularValorContrato(dataInicio, dataFim, tipoVeiculo);
        }
    }
}
