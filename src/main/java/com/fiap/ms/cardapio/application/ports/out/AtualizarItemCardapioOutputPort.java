package com.fiap.ms.cardapio.application.ports.out;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;

public interface AtualizarItemCardapioOutputPort {

    void atualizar(ItemCardapioDomain itemCardapioDomain);
}

