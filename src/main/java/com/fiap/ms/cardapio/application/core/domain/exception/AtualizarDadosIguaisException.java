package com.fiap.ms.cardapio.application.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AtualizarDadosIguaisException extends ResponseStatusException {

    public AtualizarDadosIguaisException() {
        super(HttpStatus.CONFLICT, "Dados de entrada já cadastrados para esse usuário.");
    }
}

