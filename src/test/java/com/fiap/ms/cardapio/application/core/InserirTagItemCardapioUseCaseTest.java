package com.fiap.ms.cardapio.application.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.exception.ItemCardapioNaoEncontradoException;
import com.fiap.ms.cardapio.application.core.domain.exception.TagNaoEncontradaException;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarTagsCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.InserirTagItemCardapioOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

public class InserirTagItemCardapioUseCaseTest {

    private BuscarItensCardapioOutputPort buscarItensCardapioOutputPort;
    private BuscarTagsCardapioOutputPort buscarTagsCardapioOutputPort;
    private InserirTagItemCardapioOutputPort inserirTagItemCardapioOutputPort;
    private InserirTagItemCardapioUseCase useCase;

    @BeforeEach
    void setup() {
        buscarItensCardapioOutputPort = Mockito.mock(BuscarItensCardapioOutputPort.class);
        buscarTagsCardapioOutputPort = Mockito.mock(BuscarTagsCardapioOutputPort.class);
        inserirTagItemCardapioOutputPort = Mockito.mock(InserirTagItemCardapioOutputPort.class);

        useCase = new InserirTagItemCardapioUseCase(
                buscarItensCardapioOutputPort,
                buscarTagsCardapioOutputPort,
                inserirTagItemCardapioOutputPort
        );
    }


    @Test
    void deveLancarExcecaoQuandoItemNaoExistir() {
        String usuario = "user1";
        Long idItem = 1L;
        String codigoTag = "TAG001";

        when(buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, idItem))
                .thenReturn(Optional.empty());

        assertThrows(ItemCardapioNaoEncontradoException.class,
                () -> useCase.inserirTag(usuario, idItem, codigoTag));

        verify(buscarItensCardapioOutputPort).buscarPorUsuarioEIdItemCardapio(usuario, idItem);
        verifyNoMoreInteractions(buscarTagsCardapioOutputPort, inserirTagItemCardapioOutputPort);
    }

    @Test
    void deveLancarExcecaoQuandoTagNaoExistir() {
        String usuario = "user1";
        Long idItem = 1L;
        String codigoTag = "TAG001";

        ItemCardapioDomain item = new ItemCardapioDomain();

        when(buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, idItem))
                .thenReturn(Optional.of(item));
        when(buscarTagsCardapioOutputPort.buscarTodas())
                .thenReturn(List.of());

        assertThrows(TagNaoEncontradaException.class,
                () -> useCase.inserirTag(usuario, idItem, codigoTag));

        verify(buscarItensCardapioOutputPort).buscarPorUsuarioEIdItemCardapio(usuario, idItem);
        verify(buscarTagsCardapioOutputPort).buscarTodas();
        verifyNoMoreInteractions(inserirTagItemCardapioOutputPort);
    }
}

