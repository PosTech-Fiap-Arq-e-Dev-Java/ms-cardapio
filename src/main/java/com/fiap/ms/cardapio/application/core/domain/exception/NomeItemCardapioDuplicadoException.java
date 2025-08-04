package com.fiap.ms.cardapio.application.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NomeItemCardapioDuplicadoException extends ResponseStatusException {

    public NomeItemCardapioDuplicadoException(String usuario, String nomeItem) {
        super(HttpStatus.CONFLICT,
                "Já existe um item de cardápio com o nome '" + nomeItem + "' para o usuário '" + usuario + "'.");
    }
}

