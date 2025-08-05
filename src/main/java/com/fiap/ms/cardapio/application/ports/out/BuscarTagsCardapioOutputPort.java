package com.fiap.ms.cardapio.application.ports.out;

import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;

import java.util.List;
import java.util.Optional;

public interface BuscarTagsCardapioOutputPort {

    List<TagsCardapioDomain> buscarTodas();

    Optional<TagsCardapioDomain> buscarPorCodigo(Integer codigoTags);
}