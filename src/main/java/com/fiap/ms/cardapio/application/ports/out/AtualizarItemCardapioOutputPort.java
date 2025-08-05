package com.fiap.ms.cardapio.application.ports.out;

import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;

public interface AtualizarItemCardapioOutputPort {

    void atualizar(ItemCardapioEntity entity);
}