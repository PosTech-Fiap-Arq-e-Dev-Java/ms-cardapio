package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.TagsCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarTagsCardapioAdapterTest {

    private TagsCardapioRepository repository;
    private BuscarTagsCardapioAdapter adapter;

    @BeforeEach
    void setUp() {
        repository = mock(TagsCardapioRepository.class);
        adapter = new BuscarTagsCardapioAdapter(repository);
    }

    @Test
    void buscarTodas_deveRetornarListaDeTags() {
        TagsCardapioEntity entity = new TagsCardapioEntity();
        entity.setCodigo(10);
        entity.setNome("Vegano");

        when(repository.findAllByOrderByCodigoAsc()).thenReturn(List.of(entity));

        List<TagsCardapioDomain> resultado = adapter.buscarTodas();

        assertEquals(1, resultado.size());
        assertEquals("Vegano", resultado.get(0).getNome());
        assertEquals(10, resultado.get(0).getCodigoTags());
        verify(repository, times(1)).findAllByOrderByCodigoAsc();
    }

    @Test
    void buscarPorCodigo_deveRetornarTagQuandoEncontrada() {
        TagsCardapioEntity entity = new TagsCardapioEntity();
        entity.setCodigo(20);
        entity.setNome("Fitness");

        when(repository.findByCodigo(20)).thenReturn(Optional.of(entity));

        Optional<TagsCardapioDomain> resultado = adapter.buscarPorCodigo(20);

        assertTrue(resultado.isPresent());
        assertEquals("Fitness", resultado.get().getNome());
        assertEquals(20, resultado.get().getCodigoTags());
        verify(repository, times(1)).findByCodigo(20);
    }

    @Test
    void buscarPorCodigo_deveRetornarVazioQuandoNaoEncontrada() {
        when(repository.findByCodigo(99)).thenReturn(Optional.empty());

        Optional<TagsCardapioDomain> resultado = adapter.buscarPorCodigo(99);

        assertTrue(resultado.isEmpty());
        verify(repository, times(1)).findByCodigo(99);
    }
}
