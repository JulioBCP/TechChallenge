package com.fiap.techchallenge.carrental.exceptions;

import java.time.DateTimeException;

public class CarRentalDateException extends DateTimeException{

    public CarRentalDateException(String mensagem){
        super(mensagem);
    }   
}