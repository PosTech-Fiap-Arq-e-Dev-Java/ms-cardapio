package com.fiap.ms.cardapio.application.core.handler.impl;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.handler.ItemCardapioValidatorHandler;
import com.fiap.ms.cardapio.application.core.domain.exception.AtualizarDadosIguaisException;
import com.fiap.ms.cardapio.application.core.domain.exception.CampoObrigatorioException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

@Component
public class ItemCardapioValidatorHandlerImpl implements ItemCardapioValidatorHandler {

    @Override
    public void validarCamposObrigatoriosItemCardapio(ItemCardapioDomain item) {
        if (item.getUsuario() == null || item.getUsuario().isBlank()
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
        if (item == null) {
            throw new CampoObrigatorioException();
        }

        boolean todosCamposInvalidos = Stream.of(
                isNullOrBlank(item.getNome()),
                isNullOrBlank(item.getDescricao()),
                isNullOrBlank(item.getFotoPath()),
                item.getDisponivelLocal() == null,
                isNullOrEmpty(item.getCodigoTags()),
                item.getPreco() == null || item.getPreco() <= 0
        ).allMatch(Boolean::booleanValue);

        if (todosCamposInvalidos) {
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

    private boolean isNullOrBlank(String s) {
        return s == null || s.isBlank();
    }

    private boolean isNullOrEmpty(Collection<?> c) {
        return c == null || c.isEmpty();
    }
}



