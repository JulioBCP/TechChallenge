package com.fiap.techchallenge.carrental.exceptions;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ReservaExceptionHandler {
    
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<MensagemErro> naoEncontrado(NoSuchElementException e) {
        return ResponseEntity.status(404).body(new MensagemErro(LocalDateTime.now(), 404, e.getMessage()));
    }

    @ExceptionHandler({ClienteException.class, VeiculoException.class, VeiculoReservadoException.class})
    public ResponseEntity<MensagemErro> naoEncontrado(RuntimeException e) {
        return ResponseEntity.status(422).body(new MensagemErro(LocalDateTime.now(), 422, e.getMessage()));
    }
}
