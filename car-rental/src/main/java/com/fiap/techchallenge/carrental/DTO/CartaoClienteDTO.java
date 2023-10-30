package com.fiap.techchallenge.carrental.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartaoClienteDTO {

    private String numero;

    private int mesVencimento;

    private int anoVencimento;

    private String ccv;

}
