package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.ItemCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemTagCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.mapper.ItemCardapioEntityMapper;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarItensCardapioAdapterTest {

    @Mock
    private ItemCardapioRepository itemCardapioRepository;

    @Mock
    private ItemCardapioEntityMapper mapper;

    @InjectMocks
    private BuscarItensCardapioAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarPorUsuarioEIdItemCardapio_deveRetornarOptionalComDomain() {
        String usuario = "usuario1";
        Long id = 1L;
        ItemCardapioEntity entity = new ItemCardapioEntity();
        ItemCardapioDomain domain = new ItemCardapioDomain();

        when(itemCardapioRepository.findByUsuarioAndIdItemCardapio(usuario, id)).thenReturn(Optional.of(entity));
        when(mapper.toDomain(entity)).thenReturn(domain);

        Optional<ItemCardapioDomain> resultado = adapter.buscarPorUsuarioEIdItemCardapio(usuario, id);

        assertTrue(resultado.isPresent());
        assertEquals(domain, resultado.get());
    }

    @Test
    void buscarPorUsuario_deveRetornarListaDeDomains() {
        String usuario = "usuario1";
        ItemCardapioEntity entity = new ItemCardapioEntity();
        ItemCardapioDomain domain = new ItemCardapioDomain();

        when(itemCardapioRepository.findByUsuario(usuario)).thenReturn(List.of(entity));
        when(mapper.toDomain(entity)).thenReturn(domain);

        List<ItemCardapioDomain> resultado = adapter.buscarPorUsuario(usuario);

        assertEquals(1, resultado.size());
        assertEquals(domain, resultado.get(0));
    }

    @Test
    void buscarEntityPorUsuarioEIdItemCardapio_deveRetornarOptionalEntity() {
        String usuario = "usuario1";
        Long id = 1L;
        ItemCardapioEntity entity = new ItemCardapioEntity();

        when(itemCardapioRepository.findByUsuarioAndIdItemCardapio(usuario, id)).thenReturn(Optional.of(entity));

        Optional<ItemCardapioEntity> resultado = adapter.buscarEntityPorUsuarioEIdItemCardapio(usuario, id);

        assertTrue(resultado.isPresent());
        assertEquals(entity, resultado.get());
    }

    @Test
    void verificarTagNoItem_deveRetornarTrue_QuandoTagExiste() {
        TagsCardapioEntity tag = new TagsCardapioEntity();
        tag.setCodigo(Integer.valueOf("15"));

        ItemTagCardapioEntity tagEntity = new ItemTagCardapioEntity();
        tagEntity.setCodigoTag(tag);

        ItemCardapioEntity item = new ItemCardapioEntity();
        item.setCodigoTags(List.of(tagEntity));

        boolean resultado = adapter.verificarTagNoItem(item, Integer.valueOf("15"));

        assertTrue(resultado);
    }


    @Test
    void verificarTagNoItem_deveRetornarFalse_QuandoListaVazia() {
        ItemCardapioEntity item = new ItemCardapioEntity();
        item.setCodigoTags(List.of());

        boolean resultado = adapter.verificarTagNoItem(item, 15);

        assertFalse(resultado);
    }

    @Test
    void verificarTagNoItem_deveRetornarFalse_QuandoNaoTemCodigoTags() {
        ItemCardapioEntity item = new ItemCardapioEntity();
        item.setCodigoTags(null);

        boolean resultado = adapter.verificarTagNoItem(item, 15);

        assertFalse(resultado);
    }
}

