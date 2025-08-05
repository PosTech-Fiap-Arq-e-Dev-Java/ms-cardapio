package com.fiap.ms.cardapio.adapters.out.repository.entity;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.fiap.ms.cardapio.adapters.out.repository.TagsCardapioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class TagsCardapioRepositoryTest {

    @Test
    void testFindAllByOrderByCodigoAsc() {
        TagsCardapioRepository repository = Mockito.mock(TagsCardapioRepository.class);

        TagsCardapioEntity tag1 = new TagsCardapioEntity(1, "Vegano");
        TagsCardapioEntity tag2 = new TagsCardapioEntity(2, "Sem Glúten");

        List<TagsCardapioEntity> tags = Arrays.asList(tag1, tag2);

        when(repository.findAllByOrderByCodigoAsc()).thenReturn(tags);

        List<TagsCardapioEntity> result = repository.findAllByOrderByCodigoAsc();

        assertNotNull(result);
        assertEquals(2, result.size());

        assertEquals(tag1, result.get(0));
        assertEquals(tag2, result.get(1));

        assertEquals(1, result.get(0).getCodigo());
        assertEquals("Vegano", result.get(0).getNome());
        assertEquals(2, result.get(1).getCodigo());
        assertEquals("Sem Glúten", result.get(1).getNome());
    }

    @Test
    void testFindByCodigo_found() {
        TagsCardapioRepository repository = Mockito.mock(TagsCardapioRepository.class);

        TagsCardapioEntity tag = new TagsCardapioEntity(1, "Vegano");

        when(repository.findByCodigo(1)).thenReturn(Optional.of(tag));

        Optional<TagsCardapioEntity> result = repository.findByCodigo(1);

        assertTrue(result.isPresent());
        assertEquals(tag, result.get());
    }

    @Test
    void testFindByCodigo_notFound() {
        TagsCardapioRepository repository = Mockito.mock(TagsCardapioRepository.class);

        when(repository.findByCodigo(99)).thenReturn(Optional.empty());

        Optional<TagsCardapioEntity> result = repository.findByCodigo(99);

        assertFalse(result.isPresent());
    }
}



