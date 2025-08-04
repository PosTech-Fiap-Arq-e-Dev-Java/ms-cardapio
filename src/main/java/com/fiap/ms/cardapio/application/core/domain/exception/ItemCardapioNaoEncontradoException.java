package com.fiap.ms.cardapio.application.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ItemCardapioNaoEncontradoException extends ResponseStatusException {

    public ItemCardapioNaoEncontradoException(String usuario, Long idItemCardapio) {
        super(HttpStatus.NOT_FOUND, "Cardapio não encontrado para usuário " + usuario + " e item " + idItemCardapio);
    }

    public ItemCardapioNaoEncontradoException(String usuario) {
        super(HttpStatus.NOT_FOUND, "Nenhum item de Cardapio encontrado para usuário " + usuario);
    }
}
