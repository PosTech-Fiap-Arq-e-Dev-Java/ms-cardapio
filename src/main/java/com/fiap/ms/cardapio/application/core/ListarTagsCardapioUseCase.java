package com.fiap.ms.cardapio.application.core;

import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapio.application.ports.in.ListarTagsCardapioInputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarTagsCardapioOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListarTagsCardapioUseCase implements ListarTagsCardapioInputPort {

    private final BuscarTagsCardapioOutputPort buscarTagsCardapioOutputPort;

    @Override
    public List<TagsCardapioDomain> listar() {
        return buscarTagsCardapioOutputPort.buscarTodas();
    }
}
