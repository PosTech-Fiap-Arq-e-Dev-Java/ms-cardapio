package com.fiap.ms.cardapio.application.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MaxTagsExcedidasException extends ResponseStatusException {

    public MaxTagsExcedidasException() {
        super(HttpStatus.BAD_REQUEST, "Não é permitido adicionar mais de 5 tags para um item do cardápio");
    }
}

