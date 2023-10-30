package com.fiap.techchallenge.carrental.exceptions;

import java.time.LocalDateTime;

public record MensagemErro(LocalDateTime timestamp, int status, String mensagem) {

}
