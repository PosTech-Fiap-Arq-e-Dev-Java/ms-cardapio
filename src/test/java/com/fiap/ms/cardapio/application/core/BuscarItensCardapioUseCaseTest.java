package com.fiap.ms.cardapio.application.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.exception.ItemCardapioNaoEncontradoException;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

public class BuscarItensCardapioUseCaseTest {

    private BuscarItensCardapioOutputPort buscarItensCardapioOutputPort;
    private BuscarItensCardapioUseCase useCase;

    @BeforeEach
    void setup() {
        buscarItensCardapioOutputPort = Mockito.mock(BuscarItensCardapioOutputPort.class);
        useCase = new BuscarItensCardapioUseCase(buscarItensCardapioOutputPort);
    }

    @Test
    void deveBuscarItemPorUsuarioEId_quandoExistir() {
        String usuario = "user1";
        Long id = 1L;

        ItemCardapioDomain item = new ItemCardapioDomain();
        item.setNome("Item Teste");

        when(buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, id))
                .thenReturn(Optional.of(item));

        ItemCardapioDomain resultado = useCase.buscarPorUsuarioEIdItemCardapio(usuario, id);

        assertNotNull(resultado);
        assertEquals("Item Teste", resultado.getNome());

        verify(buscarItensCardapioOutputPort).buscarPorUsuarioEIdItemCardapio(usuario, id);
    }

    @Test
    void deveLancarExcecao_quandoNaoExistirItemPorUsuarioEId() {
        String usuario = "user1";
        Long id = 1L;

        when(buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, id))
                .thenReturn(Optional.empty());

        ItemCardapioNaoEncontradoException exception = assertThrows(
                ItemCardapioNaoEncontradoException.class,
                () -> useCase.buscarPorUsuarioEIdItemCardapio(usuario, id)
        );

        assertTrue(exception.getMessage().contains(usuario));
        assertTrue(exception.getMessage().contains(id.toString()));

        verify(buscarItensCardapioOutputPort).buscarPorUsuarioEIdItemCardapio(usuario, id);
    }

    @Test
    void deveBuscarListaPorUsuario_quandoExistirItens() {
        String usuario = "user1";

        ItemCardapioDomain item1 = new ItemCardapioDomain();
        item1.setNome("Item 1");

        ItemCardapioDomain item2 = new ItemCardapioDomain();
        item2.setNome("Item 2");

        when(buscarItensCardapioOutputPort.buscarPorUsuario(usuario))
                .thenReturn(List.of(item1, item2));

        List<ItemCardapioDomain> resultado = useCase.buscarPorUsuario(usuario);

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Item 1", resultado.get(0).getNome());
        assertEquals("Item 2", resultado.get(1).getNome());

        verify(buscarItensCardapioOutputPort).buscarPorUsuario(usuario);
    }

    @Test
    void deveLancarExcecao_quandoListaVaziaOuNulaNaBuscaPorUsuario() {
        String usuario = "user1";

        when(buscarItensCardapioOutputPort.buscarPorUsuario(usuario))
                .thenReturn(List.of());

        ItemCardapioNaoEncontradoException exceptionVazia = assertThrows(
                ItemCardapioNaoEncontradoException.class,
                () -> useCase.buscarPorUsuario(usuario)
        );
        assertTrue(exceptionVazia.getMessage().contains(usuario));

        when(buscarItensCardapioOutputPort.buscarPorUsuario(usuario))
                .thenReturn(null);

        ItemCardapioNaoEncontradoException exceptionNula = assertThrows(
                ItemCardapioNaoEncontradoException.class,
                () -> useCase.buscarPorUsuario(usuario)
        );
        assertTrue(exceptionNula.getMessage().contains(usuario));

        verify(buscarItensCardapioOutputPort, times(2)).buscarPorUsuario(usuario);
    }
}

