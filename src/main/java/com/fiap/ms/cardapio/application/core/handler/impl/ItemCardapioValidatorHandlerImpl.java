package com.fiap.ms.cardapio.application.core.handler.impl;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.handler.ItemCardapioValidatorHandler;
import com.fiap.ms.cardapio.application.core.domain.exception.AtualizarDadosIguaisException;
import com.fiap.ms.cardapio.application.core.domain.exception.CampoObrigatorioException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ItemCardapioValidatorHandlerImpl implements ItemCardapioValidatorHandler {

    @Override
    public void validarCamposObrigatoriosItemCardapio(ItemCardapioDomain item) {
        if (Objects.isNull(item)
                || item.getIdItemCardapio() == null
                || item.getUsuario() == null || item.getUsuario().isBlank()
                || item.getNome() == null || item.getNome().isBlank()
                || item.getPreco() == null
                || item.getDisponivelLocal() == null
                || item.getCodigoTags() == null || item.getCodigoTags().isEmpty()
                || item.getCodigoTags().stream().anyMatch(Objects::isNull)) {
            throw new CampoObrigatorioException();
        }
    }

    @Override
    public void validarCamposObrigatoriosAtualizarItemCardapio(ItemCardapioDomain item) {
        if (Objects.isNull(item)
                || (item.getNome() != null && item.getNome().isBlank())
                || (item.getDescricao() != null && item.getDescricao().isBlank())
                || (item.getFotoPath() != null && item.getFotoPath().isBlank())
                || (item.getPreco() != null && item.getPreco() <= 0)) {
            throw new CampoObrigatorioException();
        }
    }

    @Override
    public void validarDadosIguaisItemCardapio(ItemCardapioDomain novo, ItemCardapioDomain existente) {
        if (novo.getNome() != null && novo.getNome().equalsIgnoreCase(existente.getNome())
                && novo.getDescricao() != null && novo.getDescricao().equalsIgnoreCase(existente.getDescricao())
                && novo.getPreco() != null && novo.getPreco().compareTo(existente.getPreco()) == 0
                && novo.getDisponivelLocal() != null && novo.getDisponivelLocal().equals(existente.getDisponivelLocal())
                && Objects.equals(novo.getFotoPath(), existente.getFotoPath())) {
            throw new AtualizarDadosIguaisException();
        }
    }
}


