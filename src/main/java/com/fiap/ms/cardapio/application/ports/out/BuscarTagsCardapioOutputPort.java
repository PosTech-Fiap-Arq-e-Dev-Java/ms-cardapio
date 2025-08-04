package com.fiap.ms.cardapio.application.ports.out;

import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import java.util.List;

public interface BuscarTagsCardapioOutputPort {

    List<TagsCardapioDomain> buscarTodas();
}
