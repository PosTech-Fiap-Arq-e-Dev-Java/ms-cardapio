package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.TagsCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarTagsCardapioAdapterTest {
/*
    private TagsCardapioRepository repository;
    private BuscarTagsCardapioAdapter adapter;

    @BeforeEach
    void setUp() {
        repository = mock(TagsCardapioRepository.class);
        adapter = new BuscarTagsCardapioAdapter(repository);
    }

    @Test
    void deveBuscarTodasTags() {
        // Arrange
        TagsCardapioEntity tag1 = new TagsCardapioEntity();
        tag1.setCodigo(Integer.valueOf("TAG001"));
        tag1.setNome("Bebidas");

        TagsCardapioEntity tag2 = new TagsCardapioEntity();
        tag2.setCodigo(Integer.valueOf("TAG002"));
        tag2.setNome("Sobremesas");

        when(repository.findAll()).thenReturn(List.of(tag1, tag2));

        List<TagsCardapioDomain> resultado = adapter.buscarTodas();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());

        TagsCardapioDomain primeiraTag = resultado.get(0);
        assertEquals("TAG001", primeiraTag.getCodigoTags());
        assertEquals("Bebidas", primeiraTag.getNome());

        TagsCardapioDomain segundaTag = resultado.get(1);
        assertEquals("TAG002", segundaTag.getCodigoTags());
        assertEquals("Sobremesas", segundaTag.getNome());

        verify(repository).findAll();
    }

    @Test
    void deveRetornarListaVaziaQuandoNaoExistiremTags() {
        when(repository.findAll()).thenReturn(List.of());

        List<TagsCardapioDomain> resultado = adapter.buscarTodas();

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());

        verify(repository).findAll();
    }

 */
}
