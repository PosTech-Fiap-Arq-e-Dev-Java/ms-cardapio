package com.fiap.ms.cardapio.application.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapio.application.ports.out.BuscarTagsCardapioOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

class ListarTagsCardapioUseCaseTest {

    @Mock
    private BuscarTagsCardapioOutputPort buscarTagsCardapioOutputPort;

    private ListarTagsCardapioUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        useCase = new ListarTagsCardapioUseCase(buscarTagsCardapioOutputPort);
    }

    @Test
    void listar_deveRetornarListaDeTags() {
        TagsCardapioDomain tag1 = new TagsCardapioDomain();
        tag1.setCodigoTags(1);
        tag1.setNome("Tag1");

        TagsCardapioDomain tag2 = new TagsCardapioDomain();
        tag2.setCodigoTags(2);
        tag2.setNome("Tag2");

        List<TagsCardapioDomain> tagsEsperadas = List.of(tag1, tag2);

        when(buscarTagsCardapioOutputPort.buscarTodas()).thenReturn(tagsEsperadas);

        List<TagsCardapioDomain> resultado = useCase.listar();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Tag1", resultado.get(0).getNome());
        assertEquals("Tag2", resultado.get(1).getNome());
    }

    @Test
    void buscarPorCodigo_deveRetornarTagQuandoEncontrada() {
        Integer codigo = 1;
        TagsCardapioDomain tag = new TagsCardapioDomain();
        tag.setCodigoTags(codigo);
        tag.setNome("Tag1");

        when(buscarTagsCardapioOutputPort.buscarPorCodigo(codigo)).thenReturn(Optional.of(tag));

        Optional<TagsCardapioDomain> resultado = useCase.buscarPorCodigo(codigo);

        assertTrue(resultado.isPresent());
        assertEquals("Tag1", resultado.get().getNome());
    }

    @Test
    void buscarPorCodigo_deveRetornarVazioQuandoNaoEncontrarTag() {
        Integer codigo = 99;
        when(buscarTagsCardapioOutputPort.buscarPorCodigo(codigo)).thenReturn(Optional.empty());

        Optional<TagsCardapioDomain> resultado = useCase.buscarPorCodigo(codigo);

        assertFalse(resultado.isPresent());
    }
}
