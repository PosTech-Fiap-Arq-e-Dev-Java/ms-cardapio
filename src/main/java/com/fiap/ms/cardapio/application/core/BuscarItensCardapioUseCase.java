package com.fiap.ms.cardapio.application.core;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.exception.ItemCardapioNaoEncontradoException;
import com.fiap.ms.cardapio.application.ports.in.BuscarItensCardapioInputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class BuscarItensCardapioUseCase implements BuscarItensCardapioInputPort {

    private final BuscarItensCardapioOutputPort buscarItensCardapioOutputPort;

    public BuscarItensCardapioUseCase(BuscarItensCardapioOutputPort buscarItensCardapioOutputPort) {
        this.buscarItensCardapioOutputPort = buscarItensCardapioOutputPort;
    }

    @Override
    public ItemCardapioDomain buscarPorUsuarioEIdItemCardapio(String usuario, Long idItemCardapio) {
        return buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, idItemCardapio)
                .orElseThrow(() -> new ItemCardapioNaoEncontradoException(usuario, idItemCardapio));
    }

    @Override
    public List<ItemCardapioDomain> buscarPorUsuario(String usuario) {
        List<ItemCardapioDomain> itens = buscarItensCardapioOutputPort.buscarPorUsuario(usuario);
        if (CollectionUtils.isEmpty(itens)) {
            throw new ItemCardapioNaoEncontradoException(usuario);
        }
        return itens;
    }
}


