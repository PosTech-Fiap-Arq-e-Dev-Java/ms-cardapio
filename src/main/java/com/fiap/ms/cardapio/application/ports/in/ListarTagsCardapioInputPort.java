package com.fiap.ms.cardapio.application.ports.in;

import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;

import java.util.List;

public interface ListarTagsCardapioInputPort {

    List<TagsCardapioDomain> listar();
}

