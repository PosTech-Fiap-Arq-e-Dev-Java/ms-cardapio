package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemTagCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.ItemCardapioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class DeletarItemCardapioAdapterTest {

    @Mock
    private ItemCardapioRepository itemCardapioRepository;

    @InjectMocks
    private DeletarItemCardapioAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deletarPorUsuarioEIdItemCardapio_deveDeletarQuandoItemExiste() {
        String usuario = "usuarioTeste";
        Long id = 1L;

        ItemCardapioEntity item = new ItemCardapioEntity();
        when(itemCardapioRepository.findByUsuarioAndIdItemCardapio(usuario, id)).thenReturn(Optional.of(item));

        adapter.deletarPorUsuarioEIdItemCardapio(usuario, id);

        verify(itemCardapioRepository).delete(item);
    }

    @Test
    void deletarPorUsuarioEIdItemCardapio_naoDeveDeletarQuandoItemNaoExiste() {
        String usuario = "usuarioTeste";
        Long id = 1L;

        when(itemCardapioRepository.findByUsuarioAndIdItemCardapio(usuario, id)).thenReturn(Optional.empty());

        adapter.deletarPorUsuarioEIdItemCardapio(usuario, id);

        verify(itemCardapioRepository, never()).delete(any());
    }

    @Test
    void deletarTagPorUsuarioEIdItemCardapio_deveRemoverTagQuandoExiste() {
        String usuario = "usuarioTeste";
        Long idItem = 1L;
        Integer codigoTag = 15;

        TagsCardapioEntity tag = new TagsCardapioEntity();
        tag.setCodigo(codigoTag);

        ItemTagCardapioEntity tagEntity = new ItemTagCardapioEntity();
        tagEntity.setCodigoTag(tag);

        Set<ItemTagCardapioEntity> tags = new HashSet<>();
        tags.add(tagEntity);

        ItemCardapioEntity item = new ItemCardapioEntity();
        item.setCodigoTags(new ArrayList<>(tags));

        when(itemCardapioRepository.findByUsuarioAndIdItemCardapio(usuario, idItem)).thenReturn(Optional.of(item));

        adapter.deletarTagPorUsuarioEIdItemCardapio(usuario, idItem, codigoTag);

        assertFalse(item.getCodigoTags().contains(tagEntity));
        verify(itemCardapioRepository).save(item);

    }

    @Test
    void deletarTagPorUsuarioEIdItemCardapio_naoDeveRemoverTagQuandoNaoExiste() {
        String usuario = "usuarioTeste";
        Long idItem = 1L;
        Integer codigoTag = 15;

        TagsCardapioEntity tag = new TagsCardapioEntity();
        tag.setCodigo(99);

        ItemTagCardapioEntity tagEntity = new ItemTagCardapioEntity();
        tagEntity.setCodigoTag(tag);

        Set<ItemTagCardapioEntity> tags = new HashSet<>();
        tags.add(tagEntity);

        ItemCardapioEntity item = new ItemCardapioEntity();
        item.setCodigoTags(new ArrayList<>(tags));

        when(itemCardapioRepository.findByUsuarioAndIdItemCardapio(usuario, idItem)).thenReturn(Optional.of(item));

        adapter.deletarTagPorUsuarioEIdItemCardapio(usuario, idItem, codigoTag);

        assertEquals(1, item.getCodigoTags().size());
        verify(itemCardapioRepository, never()).save(any());
    }
}


