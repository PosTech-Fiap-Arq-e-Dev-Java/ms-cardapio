package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.ItemCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarItensCardapioAdapterTest {
/*
    private ItemCardapioRepository itemCardapioRepository;
    private BuscarItensCardapioAdapter buscarItensCardapioAdapter;

    @BeforeEach
    void setUp() {
        itemCardapioRepository = mock(ItemCardapioRepository.class);
        buscarItensCardapioAdapter = new BuscarItensCardapioAdapter(itemCardapioRepository);
    }

    @Test
    void deveBuscarItemPorUsuarioEId_quandoExistir() {
        // Arrange
        String usuario = "restaurante123";
        Long id = 1L;

        ItemCardapioEntity entity = new ItemCardapioEntity();
        entity.setIdItemCardapio(id);
        entity.setUsuario(usuario);
        entity.setNome("Pizza Margherita");
        entity.setDescricao("Pizza clássica com molho de tomate e mussarela");
        entity.setPreco(BigDecimal.valueOf(39.90));
        entity.setDisponivelLocal(true);
        entity.setFotoPath("/img/pizza.png");

        when(itemCardapioRepository.findByUsuarioAndIdItemCardapio(usuario, id)).thenReturn(Optional.of(entity));

        Optional<ItemCardapioDomain> result = buscarItensCardapioAdapter.buscarPorUsuarioEIdItemCardapio(usuario, id);

        assertTrue(result.isPresent());
        assertEquals("Pizza Margherita", result.get().getNome());
        assertEquals(usuario, result.get().getUsuario());
        verify(itemCardapioRepository).findByUsuarioAndIdItemCardapio(usuario, id);
    }

    @Test
    void deveRetornarVazio_quandoNaoExistirItemPorUsuarioEId() {
        String usuario = "naoexiste";
        Long id = 99L;

        when(itemCardapioRepository.findByUsuarioAndIdItemCardapio(usuario, id)).thenReturn(Optional.empty());

        Optional<ItemCardapioDomain> result = buscarItensCardapioAdapter.buscarPorUsuarioEIdItemCardapio(usuario, id);

        assertFalse(result.isPresent());
        verify(itemCardapioRepository).findByUsuarioAndIdItemCardapio(usuario, id);
    }

    @Test
    void deveBuscarTodosItensPorUsuario() {
        String usuario = "restaurante456";

        ItemCardapioEntity entity1 = new ItemCardapioEntity();
        entity1.setIdItemCardapio(1L);
        entity1.setUsuario(usuario);
        entity1.setNome("Lasanha");
        entity1.setDescricao("Lasanha bolonhesa");
        entity1.setPreco(BigDecimal.valueOf(42.50));
        entity1.setDisponivelLocal(true);
        entity1.setFotoPath("/img/lasanha.png");

        ItemCardapioEntity entity2 = new ItemCardapioEntity();
        entity2.setIdItemCardapio(2L);
        entity2.setUsuario(usuario);
        entity2.setNome("Salada Caesar");
        entity2.setDescricao("Salada com frango grelhado e molho caesar");
        entity2.setPreco(BigDecimal.valueOf(28.90));
        entity2.setDisponivelLocal(true);
        entity2.setFotoPath("/img/salada.png");

        when(itemCardapioRepository.findByUsuario(usuario)).thenReturn(List.of(entity1, entity2));

        List<ItemCardapioDomain> result = buscarItensCardapioAdapter.buscarPorUsuario(usuario);

        assertEquals(2, result.size());
        assertEquals("Lasanha", result.get(0).getNome());
        assertEquals("Salada Caesar", result.get(1).getNome());
        verify(itemCardapioRepository).findByUsuario(usuario);
    }

 */
}

