package com.fiap.ms.cardapio.application.ports.out;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;

import java.util.List;
import java.util.Optional;

public interface BuscarItensCardapioOutputPort {

    Optional<ItemCardapioDomain> buscarPorUsuarioEId(String usuario, Long idItemCardapio);

    List<ItemCardapioDomain> buscarPorUsuario(String usuario);
}


