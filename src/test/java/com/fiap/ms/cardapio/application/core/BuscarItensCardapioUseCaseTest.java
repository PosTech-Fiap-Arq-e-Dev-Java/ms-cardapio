package com.fiap.ms.cardapio.application.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fiap.ms.cardapio.application.core.BuscarItensCardapioUseCase;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.exception.ItemCardapioNaoEncontradoException;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

public class BuscarItensCardapioUseCaseTest {

    @Mock
    private BuscarItensCardapioOutputPort outputPort;

    private BuscarItensCardapioUseCase useCase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        useCase = new BuscarItensCardapioUseCase(outputPort);
    }

    @Test
    void buscarPorUsuarioEIdItemCardapio_deveRetornarItemQuandoEncontrar() {
        String usuario = "usuario1";
        Long id = 1L;
        ItemCardapioDomain item = new ItemCardapioDomain();
        when(outputPort.buscarPorUsuarioEIdItemCardapio(usuario, id)).thenReturn(Optional.of(item));

        ItemCardapioDomain resultado = useCase.buscarPorUsuarioEIdItemCardapio(usuario, id);

        assertNotNull(resultado);
        verify(outputPort).buscarPorUsuarioEIdItemCardapio(usuario, id);
    }

    @Test
    void buscarPorUsuarioEIdItemCardapio_deveLancarExcecaoQuandoNaoEncontrar() {
        String usuario = "usuario1";
        Long id = 1L;
        when(outputPort.buscarPorUsuarioEIdItemCardapio(usuario, id)).thenReturn(Optional.empty());

        ItemCardapioNaoEncontradoException exception = assertThrows(ItemCardapioNaoEncontradoException.class, () -> {
            useCase.buscarPorUsuarioEIdItemCardapio(usuario, id);
        });

        assertTrue(exception.getMessage().contains(usuario));
        assertTrue(exception.getMessage().contains(id.toString()));
    }

    @Test
    void buscarPorUsuario_deveRetornarListaQuandoEncontrar() {
        String usuario = "usuario1";
        List<ItemCardapioDomain> lista = List.of(new ItemCardapioDomain());
        when(outputPort.buscarPorUsuario(usuario)).thenReturn(lista);

        List<ItemCardapioDomain> resultado = useCase.buscarPorUsuario(usuario);

        assertFalse(resultado.isEmpty());
        verify(outputPort).buscarPorUsuario(usuario);
    }

    @Test
    void buscarPorUsuario_deveLancarExcecaoQuandoListaVazia() {
        String usuario = "usuario1";
        when(outputPort.buscarPorUsuario(usuario)).thenReturn(List.of());

        ItemCardapioNaoEncontradoException exception = assertThrows(ItemCardapioNaoEncontradoException.class, () -> {
            useCase.buscarPorUsuario(usuario);
        });

        assertTrue(exception.getMessage().contains(usuario));
    }
}


