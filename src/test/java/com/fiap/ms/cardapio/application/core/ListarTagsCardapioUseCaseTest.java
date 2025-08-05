package com.fiap.ms.cardapio.application.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapio.application.ports.out.BuscarTagsCardapioOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class ListarTagsCardapioUseCaseTest {

    private BuscarTagsCardapioOutputPort buscarTagsCardapioOutputPort;
    private ListarTagsCardapioUseCase useCase;

    @BeforeEach
    void setup() {
        buscarTagsCardapioOutputPort = Mockito.mock(BuscarTagsCardapioOutputPort.class);
        useCase = new ListarTagsCardapioUseCase(buscarTagsCardapioOutputPort);
    }


    @Test
    void deveRetornarListaVaziaQuandoNaoExistiremTags() {
        when(buscarTagsCardapioOutputPort.buscarTodas()).thenReturn(List.of());

        List<TagsCardapioDomain> resultado = useCase.listar();

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());

        verify(buscarTagsCardapioOutputPort).buscarTodas();
    }
}
