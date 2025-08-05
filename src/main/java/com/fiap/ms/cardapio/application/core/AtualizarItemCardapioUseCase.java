package com.fiap.ms.cardapio.application.core;

import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.exception.ItemCardapioNaoEncontradoException;
import com.fiap.ms.cardapio.application.core.handler.ItemCardapioValidatorHandler;
import com.fiap.ms.cardapio.application.ports.in.AtualizarItemCardapioInputPort;
import com.fiap.ms.cardapio.application.ports.out.AtualizarItemCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;

import java.math.BigDecimal;
import java.util.Optional;


public class AtualizarItemCardapioUseCase implements AtualizarItemCardapioInputPort {

    private final BuscarItensCardapioOutputPort buscarItensCardapioOutputPort;
    private final AtualizarItemCardapioOutputPort atualizarItemCardapioOutputPort;
    private final ItemCardapioValidatorHandler itemCardapioValidatorHandler;

    public AtualizarItemCardapioUseCase(
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

        ItemCardapioEntity entity = buscarItensCardapioOutputPort.buscarEntityPorUsuarioEIdItemCardapio(usuario, idItemCardapio)
                .orElseThrow(() -> new ItemCardapioNaoEncontradoException(usuario, idItemCardapio));

        aplicarAtualizacoesParciais(itemAtualizado, entity);

        atualizarItemCardapioOutputPort.atualizar(entity);
    }

    private void aplicarAtualizacoesParciais(ItemCardapioDomain domain, ItemCardapioEntity entity) {
        Optional.ofNullable(domain.getNome()).ifPresent(entity::setNome);
        Optional.ofNullable(domain.getDescricao()).ifPresent(entity::setDescricao);
        Optional.ofNullable(domain.getPreco()).ifPresent(p -> entity.setPreco(BigDecimal.valueOf(p)));
        Optional.ofNullable(domain.getDisponivelLocal()).ifPresent(entity::setDisponivelLocal);
        Optional.ofNullable(domain.getFotoPath()).ifPresent(entity::setFotoPath);
    }
}