package com.fiap.ms.cardapio.application.ports.out;

import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;

public interface InserirTagItemCardapioOutputPort {

    void inserir(String usuario, Long idItemCardapio, TagsCardapioDomain tags);
}


