package com.fiap.techchallenge.carrental.exceptions;

import java.time.DateTimeException;

public class CarRentalDateExceptions extends DateTimeException{

    public CarRentalDateExceptions(String mensagem){
        super(mensagem);
    }   
}