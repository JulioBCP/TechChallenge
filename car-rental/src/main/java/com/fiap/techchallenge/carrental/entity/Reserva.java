package com.fiap.techchallenge.carrental.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fiap.techchallenge.carrental.exceptions.CarRentalDateException;
import com.fiap.techchallenge.carrental.exceptions.VeiculoException;
import com.fiap.techchallenge.carrental.exceptions.VeiculoReservadoException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Veiculo veiculo;

    @Column(nullable = false)
    private Double valorReserva;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataFim;

    public double calculaValorReserva(LocalDate dataInicio, LocalDate dataFim, Veiculo veiculo)
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
            return ContratoCalculator.calculoValorContrato(dataInicio, dataFim, tipoVeiculo);
        }
    }

    public void verificarSeExisteReserva(List<Reserva> listaDeReserva) {

        Period period = Period.between(dataInicio, dataFim);
        Stream<LocalDate> datesUntil = dataInicio.datesUntil(dataFim, period);
        datesUntil.findFirst().isPresent();

        boolean veiculoReservado = listaDeReserva.stream()
                                                .anyMatch(
                                                    r -> (r.getVeiculo().getId() == veiculo.getId() &&
                                                    dataInicio.isEqual(r.getDataInicio())) ||
                                                    (dataInicio.isAfter(r.getDataInicio()) &&
                                                    dataInicio.isBefore(r.getDataFim()))
                                                );

        if (veiculoReservado) {
            throw new VeiculoReservadoException("Veículo não disponivel nesse periodo!");
        }
    }
}
