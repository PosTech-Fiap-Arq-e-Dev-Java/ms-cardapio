package com.fiap.ms.cardapio.application.core.handler.impl;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.exception.AtualizarDadosIguaisException;
import com.fiap.ms.cardapio.application.core.domain.exception.CampoObrigatorioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemCardapioValidatorHandlerImplTest {

    private ItemCardapioValidatorHandlerImpl validator;

    @BeforeEach
    void setUp() {
        validator = new ItemCardapioValidatorHandlerImpl();
    }

    @Test
    void validarCamposObrigatoriosItemCardapio_DeveLancarExcecao_QuandoCampoObrigatorioEstiverAusente() {
        ItemCardapioDomain item = new ItemCardapioDomain();
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosItemCardapio(item));
    }

    @Test
    void validarCamposObrigatoriosItemCardapio_DevePassar_QuandoTodosCamposEstiveremPresentes() {
        ItemCardapioDomain item = new ItemCardapioDomain();
        item.setUsuario("usuario");
        item.setNome("Pizza");
        item.setPreco(25.0);
        item.setDisponivelLocal(true);
        item.setCodigoTags(List.of(1, 2));

        assertDoesNotThrow(() -> validator.validarCamposObrigatoriosItemCardapio(item));
    }

    @Test
    void validarCamposObrigatoriosAtualizarItemCardapio_DeveLancarExcecao_QuandoItemForNulo() {
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosAtualizarItemCardapio(null));
    }

    @Test
    void validarCamposObrigatoriosAtualizarItemCardapio_DeveLancarExcecao_QuandoTodosCamposForemInvalidos() {
        ItemCardapioDomain item = new ItemCardapioDomain();
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosAtualizarItemCardapio(item));
    }

    @Test
    void validarCamposObrigatoriosAtualizarItemCardapio_DevePassar_QuandoPeloMenosUmCampoForValido() {
        ItemCardapioDomain item = new ItemCardapioDomain();
        item.setNome("Nova Pizza");
        assertDoesNotThrow(() -> validator.validarCamposObrigatoriosAtualizarItemCardapio(item));
    }

    @Test
    void validarDadosIguaisItemCardapio_DeveLancarExcecao_QuandoTodosOsCamposForemIguais() {
        ItemCardapioDomain existente = new ItemCardapioDomain();
        existente.setNome("Pizza");
        existente.setDescricao("Deliciosa");
        existente.setPreco(20.0);
        existente.setDisponivelLocal(true);
        existente.setFotoPath("/imagens/pizza.jpg");

        ItemCardapioDomain novo = new ItemCardapioDomain();
        novo.setNome("Pizza");
        novo.setDescricao("Deliciosa");
        novo.setPreco(20.0);
        novo.setDisponivelLocal(true);
        novo.setFotoPath("/imagens/pizza.jpg");

        assertThrows(AtualizarDadosIguaisException.class, () -> validator.validarDadosIguaisItemCardapio(novo, existente));
    }

    @Test
    void validarDadosIguaisItemCardapio_DevePassar_QuandoAlgumCampoForDiferente() {
        ItemCardapioDomain existente = new ItemCardapioDomain();
        existente.setNome("Pizza");
        existente.setDescricao("Deliciosa");
        existente.setPreco(20.0);
        existente.setDisponivelLocal(true);
        existente.setFotoPath("/imagens/pizza.jpg");

        ItemCardapioDomain novo = new ItemCardapioDomain();
        novo.setNome("Pizza Nova");
        novo.setDescricao("Deliciosa");
        novo.setPreco(20.0);
        novo.setDisponivelLocal(true);
        novo.setFotoPath("/imagens/pizza.jpg");

        assertDoesNotThrow(() -> validator.validarDadosIguaisItemCardapio(novo, existente));
    }
}

