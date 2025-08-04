package com.fiap.ms.cardapio.application.core;

import com.fiap.ms.cardapio.application.core.domain.exception.ItemCardapioNaoEncontradoException;
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
    public void deletarPorUsuarioEId(String usuario, Long idItemCardapio) {
        buscarItensCardapioOutputPort.buscarPorUsuarioEId(usuario, idItemCardapio)
                .orElseThrow(() -> new ItemCardapioNaoEncontradoException(usuario, idItemCardapio));

        deletarItemCardapioOutputPort.deletarPorUsuarioEId(usuario, idItemCardapio);
    }

    @Override
    public void deletarTagPorUsuarioEId(String usuario, Long idItemCardapio, String codigoTags) {
        buscarItensCardapioOutputPort.buscarPorUsuarioEId(usuario, idItemCardapio)
                .orElseThrow(() -> new ItemCardapioNaoEncontradoException(usuario, idItemCardapio));

        deletarItemCardapioOutputPort.deletarTagPorUsuarioEId(usuario, idItemCardapio, codigoTags);
    }
}


