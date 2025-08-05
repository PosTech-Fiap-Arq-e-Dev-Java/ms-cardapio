package com.fiap.ms.cardapio.application.ports.out;

import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;

import java.util.List;
import java.util.Optional;

public interface BuscarItensCardapioOutputPort {

    Optional<ItemCardapioDomain> buscarPorUsuarioEIdItemCardapio(String usuario, Long idItemCardapio);

    List<ItemCardapioDomain> buscarPorUsuario(String usuario);

    Optional<ItemCardapioEntity> buscarEntityPorUsuarioEIdItemCardapio(String usuario, Long idItemCardapio);

    boolean verificarTagNoItem(ItemCardapioEntity itemEntity, Integer codigoTags);
}


