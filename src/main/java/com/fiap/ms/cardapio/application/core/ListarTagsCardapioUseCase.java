package com.fiap.ms.cardapio.application.core;

import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapio.application.ports.in.ListarTagsCardapioInputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarTagsCardapioOutputPort;

import java.util.List;
import java.util.Optional;

public class ListarTagsCardapioUseCase implements ListarTagsCardapioInputPort {

    private final BuscarTagsCardapioOutputPort buscarTagsCardapioOutputPort;

    public ListarTagsCardapioUseCase(BuscarTagsCardapioOutputPort buscarTagsCardapioOutputPort) {
        this.buscarTagsCardapioOutputPort = buscarTagsCardapioOutputPort;
    }

    @Override
    public List<TagsCardapioDomain> listar() {
        return buscarTagsCardapioOutputPort.buscarTodas();
    }

    @Override
    public Optional<TagsCardapioDomain> buscarPorCodigo(Integer codigoTag) {
        return buscarTagsCardapioOutputPort.buscarPorCodigo(codigoTag);
    }
}
