package com.fiap.ms.cardapio.application.ports.in;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import java.util.List;

public interface BuscarItensCardapioInputPort {

    ItemCardapioDomain buscarPorUsuarioEId(String usuario, Long idItemCardapio);

    List<ItemCardapioDomain> buscarPorUsuario(String usuario);
}



