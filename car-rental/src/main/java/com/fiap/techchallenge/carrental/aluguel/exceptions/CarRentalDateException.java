package com.fiap.techchallenge.carrental.aluguel.exceptions;

import java.time.DateTimeException;

public class CarRentalDateException extends DateTimeException{

    public CarRentalDateException(String mensagem){
        super(mensagem);
    }   
}