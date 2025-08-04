package com.fiap.ms.cardapio.application.ports.in;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;

public interface InserirItemCardapioInputPort {

    void inserir(ItemCardapioDomain itemCardapioDomain);
}

