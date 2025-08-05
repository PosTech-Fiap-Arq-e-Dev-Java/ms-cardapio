package com.fiap.ms.cardapio.application.ports.in;

import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;

import java.util.List;
import java.util.Optional;

public interface ListarTagsCardapioInputPort {

    List<TagsCardapioDomain> listar();

    Optional<TagsCardapioDomain> buscarPorCodigo(Integer codigoTag);
}