package com.fiap.ms.cardapio.application.core;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.exception.ItemCardapioNaoEncontradoException;
import com.fiap.ms.cardapio.application.core.handler.ItemCardapioValidatorHandler;
import com.fiap.ms.cardapio.application.ports.out.AtualizarItemCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AtualizaItemCardapioUseCaseTest {
/*
    @Mock
    private BuscarItensCardapioOutputPort buscarItensCardapioOutputPort;

    @Mock
    private AtualizarItemCardapioOutputPort atualizarItemCardapioOutputPort;

    @Mock
    private ItemCardapioValidatorHandler itemCardapioValidatorHandler;

    @InjectMocks
    private AtualizaItemCardapioUseCase useCase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveAtualizarItemQuandoExistir() {
        String usuario = "user1";
        Long idItem = 10L;

        ItemCardapioDomain itemExistente = new ItemCardapioDomain();
        itemExistente.setNome("Nome Antigo");
        itemExistente.setDescricao("Descrição Antiga");
        itemExistente.setPreco(10.0);
        itemExistente.setDisponivelLocal(true);
        itemExistente.setFotoPath("antiga.jpg");
        itemExistente.setCodigoTags(List.of(Integer.valueOf("01")));

        ItemCardapioDomain itemAtualizado = new ItemCardapioDomain();
        itemAtualizado.setNome("Nome Novo");
        itemAtualizado.setDescricao("Descrição Nova");
        itemAtualizado.setPreco(20.0);
        itemAtualizado.setDisponivelLocal(false);
        itemAtualizado.setFotoPath("nova.jpg");

        when(buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, idItem))
                .thenReturn(Optional.of(itemExistente));

        doNothing().when(itemCardapioValidatorHandler).validarCamposObrigatoriosAtualizarItemCardapio(itemAtualizado);

        doNothing().when(itemCardapioValidatorHandler).validarDadosIguaisItemCardapio(itemAtualizado, itemExistente);

        useCase.atualizar(usuario, idItem, itemAtualizado);

        assertEquals("Nome Novo", itemExistente.getNome());
        assertEquals("Descrição Nova", itemExistente.getDescricao());
        assertEquals(20.0, itemExistente.getPreco());
        assertEquals(false, itemExistente.getDisponivelLocal());
        assertEquals("nova.jpg", itemExistente.getFotoPath());

        verify(itemCardapioValidatorHandler).validarCamposObrigatoriosAtualizarItemCardapio(itemAtualizado);
        verify(itemCardapioValidatorHandler).validarDadosIguaisItemCardapio(itemAtualizado, itemExistente);
        verify(buscarItensCardapioOutputPort).buscarPorUsuarioEIdItemCardapio(usuario, idItem);
        verify(atualizarItemCardapioOutputPort).atualizar(itemExistente);
    }

    @Test
    void deveLancarExcecaoQuandoItemNaoEncontrado() {
        String usuario = "user1";
        Long idItem = 10L;

        ItemCardapioDomain itemAtualizado = new ItemCardapioDomain();

        when(buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, idItem))
                .thenReturn(Optional.empty());

        assertThrows(ItemCardapioNaoEncontradoException.class, () -> {
            useCase.atualizar(usuario, idItem, itemAtualizado);
        });

        verify(atualizarItemCardapioOutputPort, never()).atualizar(any());
    }

 */
}
