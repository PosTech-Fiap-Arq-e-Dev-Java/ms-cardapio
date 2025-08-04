package com.fiap.ms.cardapio.application.core.handler;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;


public interface ItemCardapioValidatorHandler {

    void validarCamposObrigatoriosItemCardapio(ItemCardapioDomain itemCardapioDomain);

    void validarCamposObrigatoriosAtualizarItemCardapio(ItemCardapioDomain itemCardapioDomain);

    void validarDadosIguaisItemCardapio(ItemCardapioDomain novo, ItemCardapioDomain existente);
}
