package com.fiap.ms.cardapio.application.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TagNaoEncontradaException extends ResponseStatusException {

    public TagNaoEncontradaException(String codigoTags) {
        super(HttpStatus.NOT_FOUND, "Tag com código " + codigoTags + " não encontrada.");
    }
}

