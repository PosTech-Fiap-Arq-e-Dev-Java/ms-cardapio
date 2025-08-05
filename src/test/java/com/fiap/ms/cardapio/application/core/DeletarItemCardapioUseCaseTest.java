package com.fiap.ms.cardapio.application.core;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.exception.ItemCardapioNaoEncontradoException;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.DeletarItemCardapioOutputPort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class DeletarItemCardapioUseCaseTest {

    @Mock
    private BuscarItensCardapioOutputPort buscarOutputPort;

    @Mock
    private DeletarItemCardapioOutputPort deletarOutputPort;

    private DeletarItemCardapioUseCase useCase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        useCase = new DeletarItemCardapioUseCase(deletarOutputPort, buscarOutputPort);
    }

    @Test
    void deletarPorUsuarioEIdItemCardapio_deveDeletarQuandoItemExiste() {
        String usuario = "usuario1";
        Long id = 1L;

        ItemCardapioDomain itemDomain = new ItemCardapioDomain();
        when(buscarOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, id)).thenReturn(Optional.of(itemDomain));

        useCase.deletarPorUsuarioEIdItemCardapio(usuario, id);

        verify(deletarOutputPort).deletarPorUsuarioEIdItemCardapio(usuario, id);
    }

    @Test
    void deletarPorUsuarioEIdItemCardapio_deveLancarExcecaoQuandoNaoEncontrarItem() {
        String usuario = "usuario1";
        Long id = 1L;

        when(buscarOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, id))
                .thenReturn(Optional.empty());

        ItemCardapioNaoEncontradoException exception = assertThrows(
                ItemCardapioNaoEncontradoException.class,
                () -> useCase.deletarPorUsuarioEIdItemCardapio(usuario, id)
        );

        String expectedMessage = "Cardapio não encontrado para usuário " + usuario + " e item " + id;
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

}



