package com.fiap.ms.cardapio.adapters.out.repository.entity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fiap.ms.cardapio.adapters.out.repository.ItemTagCardapioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

class ItemTagCardapioRepositoryTest {

    @Test
    void testFindByItemCardapio_IdItemCardapioAndCodigoTag_CodigoAndItemCardapio_Usuario_found() {
        ItemTagCardapioRepository repository = Mockito.mock(ItemTagCardapioRepository.class);

        ItemCardapioEntity itemCardapio = new ItemCardapioEntity();
        itemCardapio.setIdItemCardapio(1L);
        itemCardapio.setUsuario("usuario1");

        TagsCardapioEntity tag = new TagsCardapioEntity();
        tag.setCodigo(10);

        ItemTagCardapioEntity entity = new ItemTagCardapioEntity(
                1L,
                itemCardapio,
                tag
        );

        when(repository.findByItemCardapio_IdItemCardapioAndCodigoTag_CodigoAndItemCardapio_Usuario(1L, 10, "usuario1"))
                .thenReturn(Optional.of(entity));

        Optional<ItemTagCardapioEntity> result =
                repository.findByItemCardapio_IdItemCardapioAndCodigoTag_CodigoAndItemCardapio_Usuario(1L, 10, "usuario1");

        assertTrue(result.isPresent());
        assertEquals(entity, result.get());

        verify(repository, times(1))
                .findByItemCardapio_IdItemCardapioAndCodigoTag_CodigoAndItemCardapio_Usuario(1L, 10, "usuario1");
    }

    @Test
    void testFindByItemCardapio_IdItemCardapioAndCodigoTag_CodigoAndItemCardapio_Usuario_notFound() {
        ItemTagCardapioRepository repository = Mockito.mock(ItemTagCardapioRepository.class);

        when(repository.findByItemCardapio_IdItemCardapioAndCodigoTag_CodigoAndItemCardapio_Usuario(1L, 99, "usuario2"))
                .thenReturn(Optional.empty());

        Optional<ItemTagCardapioEntity> result =
                repository.findByItemCardapio_IdItemCardapioAndCodigoTag_CodigoAndItemCardapio_Usuario(1L, 99, "usuario2");

        assertFalse(result.isPresent());

        verify(repository, times(1))
                .findByItemCardapio_IdItemCardapioAndCodigoTag_CodigoAndItemCardapio_Usuario(1L, 99, "usuario2");
    }
}

