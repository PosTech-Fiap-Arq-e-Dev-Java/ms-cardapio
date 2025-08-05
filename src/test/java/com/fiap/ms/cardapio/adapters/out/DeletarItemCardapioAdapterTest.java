package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.ItemCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.ItemTagCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemTagCardapioEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

class DeletarItemCardapioAdapterTest {
/*
    private ItemCardapioRepository itemCardapioRepository;
    private ItemTagCardapioRepository itemTagCardapioRepository;
    private DeletarItemCardapioAdapter adapter;

    @BeforeEach
    void setUp() {
        itemCardapioRepository = mock(ItemCardapioRepository.class);
        itemTagCardapioRepository = mock(ItemTagCardapioRepository.class);
        adapter = new DeletarItemCardapioAdapter(itemCardapioRepository, itemTagCardapioRepository);
    }

    @Test
    void deveDeletarItemCardapioQuandoExistir() {
        String usuario = "restaurante1";
        Long idItem = 1L;

        ItemCardapioEntity entity = new ItemCardapioEntity();
        entity.setIdItemCardapio(idItem);
        entity.setUsuario(usuario);

        when(itemCardapioRepository.findByUsuarioAndIdItemCardapio(usuario, idItem)).thenReturn(Optional.of(entity));

        adapter.deletarPorUsuarioEIdItemCardapio(usuario, idItem);

        verify(itemCardapioRepository).findByUsuarioAndIdItemCardapio(usuario, idItem);
        verify(itemCardapioRepository).delete(entity);
    }

    @Test
    void naoDeveDeletarItemCardapioQuandoNaoExistir() {
        String usuario = "restaurante1";
        Long idItem = 2L;

        when(itemCardapioRepository.findByUsuarioAndIdItemCardapio(usuario, idItem)).thenReturn(Optional.empty());

        adapter.deletarPorUsuarioEIdItemCardapio(usuario, idItem);

        verify(itemCardapioRepository).findByUsuarioAndIdItemCardapio(usuario, idItem);
        verify(itemCardapioRepository, never()).delete(any());
    }

    @Test
    void deveDeletarTagPorUsuarioEIdItemCardapioQuandoExistir() {
        String usuario = "restaurante1";
        Long idItem = 1L;
        String codigoTag = "TAG001";

        ItemTagCardapioEntity tagEntity = new ItemTagCardapioEntity();

        when(itemTagCardapioRepository.findByItemCardapio_IdItemCardapioAndCodigoTag_CodigoAndItemCardapio_Usuario(idItem, Integer.valueOf(codigoTag), usuario))
                .thenReturn(Optional.of(tagEntity));

        adapter.deletarTagPorUsuarioEIdItemCardapio(usuario, idItem, Integer.valueOf(codigoTag));

        verify(itemTagCardapioRepository).findByItemCardapio_IdItemCardapioAndCodigoTag_CodigoAndItemCardapio_Usuario(idItem, Integer.valueOf(codigoTag), usuario);

        verify(itemTagCardapioRepository).delete(tagEntity);
    }


    @Test
    void naoDeveDeletarTagQuandoNaoExistir() {
        String usuario = "restaurante1";
        Long idItem = 2L;
        String codigoTag = "TAG002";

        when(itemTagCardapioRepository.findByItemCardapio_IdItemCardapioAndCodigoTag_CodigoAndItemCardapio_Usuario(idItem, Integer.valueOf(codigoTag), usuario))
                .thenReturn(Optional.empty());

        adapter.deletarTagPorUsuarioEIdItemCardapio(usuario, idItem, Integer.valueOf(codigoTag));

        verify(itemTagCardapioRepository).findByItemCardapio_IdItemCardapioAndCodigoTag_CodigoAndItemCardapio_Usuario(idItem, Integer.valueOf(codigoTag), usuario);
        verify(itemTagCardapioRepository, never()).delete(any());
    }

 */
}

