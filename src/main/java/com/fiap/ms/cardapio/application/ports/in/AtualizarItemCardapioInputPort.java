package com.fiap.ms.cardapio.application.ports.in;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;

public interface AtualizarItemCardapioInputPort {

    void atualizar(String usuario, Long idItemCardapio, ItemCardapioDomain itemAtualizado);
}


