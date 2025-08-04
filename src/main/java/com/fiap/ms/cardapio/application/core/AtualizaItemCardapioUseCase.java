package com.fiap.ms.cardapio.application.core;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.exception.ItemCardapioNaoEncontradoException;
import com.fiap.ms.cardapio.application.core.handler.ItemCardapioValidatorHandler;
import com.fiap.ms.cardapio.application.ports.in.AtualizarItemCardapioInputPort;
import com.fiap.ms.cardapio.application.ports.out.AtualizarItemCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;

public class AtualizaItemCardapioUseCase implements AtualizarItemCardapioInputPort {

    private final BuscarItensCardapioOutputPort buscarItensCardapioOutputPort;
    private final AtualizarItemCardapioOutputPort atualizarItemCardapioOutputPort;
    private final ItemCardapioValidatorHandler itemCardapioValidatorHandler;

    public AtualizaItemCardapioUseCase(
            BuscarItensCardapioOutputPort buscarItensCardapioOutputPort,
            AtualizarItemCardapioOutputPort atualizarItemCardapioOutputPort,
            ItemCardapioValidatorHandler itemCardapioValidatorHandler) {
        this.buscarItensCardapioOutputPort = buscarItensCardapioOutputPort;
        this.atualizarItemCardapioOutputPort = atualizarItemCardapioOutputPort;
        this.itemCardapioValidatorHandler = itemCardapioValidatorHandler;
    }

    @Override
    public void atualizar(String usuario, Long idItemCardapio, ItemCardapioDomain itemAtualizado) {
        itemCardapioValidatorHandler.validarCamposObrigatoriosAtualizarItemCardapio(itemAtualizado);

        ItemCardapioDomain existente = buscarItensCardapioOutputPort.buscarPorUsuarioEId(usuario, idItemCardapio)
                .orElseThrow(() -> new ItemCardapioNaoEncontradoException(usuario, idItemCardapio));
        itemCardapioValidatorHandler.validarDadosIguaisItemCardapio(itemAtualizado, existente);

        existente.setNome(itemAtualizado.getNome());
        existente.setDescricao(itemAtualizado.getDescricao());
        existente.setPreco(itemAtualizado.getPreco());
        existente.setDisponivelLocal(itemAtualizado.getDisponivelLocal());
        existente.setFotoPath(itemAtualizado.getFotoPath());
        existente.setCodigoTags(itemAtualizado.getCodigoTags());

        atualizarItemCardapioOutputPort.atualizar(existente);
    }
}

