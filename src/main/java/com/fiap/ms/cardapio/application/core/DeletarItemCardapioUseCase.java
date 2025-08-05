package com.fiap.ms.cardapio.application.core;

import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.exception.ItemCardapioNaoEncontradoException;
import com.fiap.ms.cardapio.application.core.domain.exception.TagNaoEncontradaException;
import com.fiap.ms.cardapio.application.ports.in.DeletarItemCardapioInputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.DeletarItemCardapioOutputPort;

public class DeletarItemCardapioUseCase implements DeletarItemCardapioInputPort {

    private final DeletarItemCardapioOutputPort deletarItemCardapioOutputPort;
    private final BuscarItensCardapioOutputPort buscarItensCardapioOutputPort;

    public DeletarItemCardapioUseCase(DeletarItemCardapioOutputPort deletarItemCardapioOutputPort,
                                      BuscarItensCardapioOutputPort buscarItensCardapioOutputPort) {
        this.deletarItemCardapioOutputPort = deletarItemCardapioOutputPort;
        this.buscarItensCardapioOutputPort = buscarItensCardapioOutputPort;
    }

    @Override
    public void deletarPorUsuarioEIdItemCardapio(String usuario, Long idItemCardapio) {
        buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, idItemCardapio)
                .orElseThrow(() -> new ItemCardapioNaoEncontradoException(usuario, idItemCardapio));

        deletarItemCardapioOutputPort.deletarPorUsuarioEIdItemCardapio(usuario, idItemCardapio);
    }

    @Override
    public void deletarTagPorUsuarioEIdItemCardapio(String usuario, Long idItemCardapio, Integer codigoTags) {
        ItemCardapioEntity itemEntity = buscarItensCardapioOutputPort.buscarEntityPorUsuarioEIdItemCardapio(usuario, idItemCardapio)
                .orElseThrow(() -> new ItemCardapioNaoEncontradoException(usuario, idItemCardapio));

        boolean tagExiste = buscarItensCardapioOutputPort.verificarTagNoItem(itemEntity, codigoTags);

        if (!tagExiste) {
            throw new TagNaoEncontradaException(codigoTags.toString());
        }
        deletarItemCardapioOutputPort.deletarTagPorUsuarioEIdItemCardapio(usuario, idItemCardapio, codigoTags);
    }
}


