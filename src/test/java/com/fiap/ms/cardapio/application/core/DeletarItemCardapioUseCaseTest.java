package com.fiap.ms.cardapio.application.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.exception.ItemCardapioNaoEncontradoException;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.DeletarItemCardapioOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class DeletarItemCardapioUseCaseTest {
/*
    private DeletarItemCardapioOutputPort deletarItemCardapioOutputPort;
    private BuscarItensCardapioOutputPort buscarItensCardapioOutputPort;
    private DeletarItemCardapioUseCase useCase;

    @BeforeEach
    void setup() {
        deletarItemCardapioOutputPort = Mockito.mock(DeletarItemCardapioOutputPort.class);
        buscarItensCardapioOutputPort = Mockito.mock(BuscarItensCardapioOutputPort.class);
        useCase = new DeletarItemCardapioUseCase(deletarItemCardapioOutputPort, buscarItensCardapioOutputPort);
    }

    @Test
    void deveDeletarItemQuandoExistir() {
        String usuario = "user1";
        Long id = 1L;

        ItemCardapioDomain itemExistente = new ItemCardapioDomain();

        when(buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, id))
                .thenReturn(Optional.of(itemExistente));

        useCase.deletarPorUsuarioEIdItemCardapio(usuario, id);

        verify(buscarItensCardapioOutputPort).buscarPorUsuarioEIdItemCardapio(usuario, id);
        verify(deletarItemCardapioOutputPort).deletarPorUsuarioEIdItemCardapio(usuario, id);
    }

    @Test
    void deveLancarExcecaoAoDeletarItemInexistente() {
        String usuario = "user1";
        Long id = 1L;

        when(buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, id))
                .thenReturn(Optional.empty());

        ItemCardapioNaoEncontradoException exception = assertThrows(
                ItemCardapioNaoEncontradoException.class,
                () -> useCase.deletarPorUsuarioEIdItemCardapio(usuario, id)
        );

        assertTrue(exception.getMessage().contains(usuario));
        assertTrue(exception.getMessage().contains(id.toString()));

        verify(buscarItensCardapioOutputPort).buscarPorUsuarioEIdItemCardapio(usuario, id);
        verifyNoInteractions(deletarItemCardapioOutputPort);
    }

    @Test
    void deveDeletarTagDoItemQuandoExistir() {
        String usuario = "user1";
        Long id = 1L;
        String codigoTags = "TAG001";

        ItemCardapioDomain itemExistente = new ItemCardapioDomain();

        when(buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, id))
                .thenReturn(Optional.of(itemExistente));

        useCase.deletarTagPorUsuarioEIdItemCardapio(usuario, id, Integer.valueOf(codigoTags));

        verify(buscarItensCardapioOutputPort).buscarPorUsuarioEIdItemCardapio(usuario, id);
        verify(deletarItemCardapioOutputPort).deletarTagPorUsuarioEIdItemCardapio(usuario, id, Integer.valueOf(codigoTags));
    }

    @Test
    void deveLancarExcecaoAoDeletarTagDeItemInexistente() {
        String usuario = "user1";
        Long id = 1L;
        String codigoTags = "TAG001";

        when(buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, id))
                .thenReturn(Optional.empty());

        ItemCardapioNaoEncontradoException exception = assertThrows(
                ItemCardapioNaoEncontradoException.class,
                () -> useCase.deletarTagPorUsuarioEIdItemCardapio(usuario, id, Integer.valueOf(codigoTags))
        );

        assertTrue(exception.getMessage().contains(usuario));
        assertTrue(exception.getMessage().contains(id.toString()));

        verify(buscarItensCardapioOutputPort).buscarPorUsuarioEIdItemCardapio(usuario, id);
        verifyNoInteractions(deletarItemCardapioOutputPort);
    }

 */
}

