package com.fiap.ms.cardapio.adapters.out.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class ItemCardapioRepositoryTest {

    @Mock
    private ItemCardapioRepository repository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByUsuarioAndIdItemCardapio() {
        ItemCardapioEntity item = new ItemCardapioEntity(
                1L,
                "Feijoada",
                "Feijoada completa",
                new BigDecimal("29.90"),
                true,
                "/imagens/feijoada.jpg",
                "usuario1",
                null
        );

        when(repository.findByUsuarioAndIdItemCardapio("usuario1", 1L)).thenReturn(Optional.of(item));

        Optional<ItemCardapioEntity> result = repository.findByUsuarioAndIdItemCardapio("usuario1", 1L);

        assertTrue(result.isPresent());
        assertEquals("Feijoada", result.get().getNome());
        assertEquals("usuario1", result.get().getUsuario());

        verify(repository, times(1)).findByUsuarioAndIdItemCardapio("usuario1", 1L);
    }

    @Test
    void testFindByUsuario() {
        ItemCardapioEntity item1 = new ItemCardapioEntity(
                1L,
                "Pizza",
                "Pizza de calabresa",
                new BigDecimal("35.00"),
                true,
                null,
                "usuario2",
                null
        );

        ItemCardapioEntity item2 = new ItemCardapioEntity(
                2L,
                "Lasanha",
                "Lasanha bolonhesa",
                new BigDecimal("30.00"),
                true,
                null,
                "usuario2",
                null
        );

        when(repository.findByUsuario("usuario2")).thenReturn(Arrays.asList(item1, item2));

        List<ItemCardapioEntity> list = repository.findByUsuario("usuario2");

        assertNotNull(list);
        assertEquals(2, list.size());
        assertEquals("Pizza", list.get(0).getNome());
        assertEquals("Lasanha", list.get(1).getNome());

        verify(repository, times(1)).findByUsuario("usuario2");
    }

    @Test
    void testFindByUsuarioAndIdItemCardapio_NotFound() {
        when(repository.findByUsuarioAndIdItemCardapio("usuario1", 999L)).thenReturn(Optional.empty());

        Optional<ItemCardapioEntity> result = repository.findByUsuarioAndIdItemCardapio("usuario1", 999L);

        assertFalse(result.isPresent());

        verify(repository, times(1)).findByUsuarioAndIdItemCardapio("usuario1", 999L);
    }

    @Test
    void testLombokDataMethods() {
        ItemCardapioEntity item1 = new ItemCardapioEntity(
                1L,
                "Feijoada",
                "Feijoada completa",
                new BigDecimal("29.90"),
                true,
                "/imagens/feijoada.jpg",
                "usuario1",
                new ArrayList<>()  // inicializa aqui para evitar null vs []
        );

        ItemCardapioEntity item2 = new ItemCardapioEntity();
        item2.setIdItemCardapio(1L);
        item2.setNome("Feijoada");
        item2.setDescricao("Feijoada completa");
        item2.setPreco(new BigDecimal("29.90"));
        item2.setDisponivelLocal(true);
        item2.setFotoPath("/imagens/feijoada.jpg");
        item2.setUsuario("usuario1");
        item2.setCodigoTags(new ArrayList<>());  // também inicializa

        assertEquals(item1, item2);
        assertEquals(item1.hashCode(), item2.hashCode());

        assertTrue(item1.toString().contains("Feijoada"));

        item2.setNome("Feijoada nova");
        assertEquals("Feijoada nova", item2.getNome());
    }

}
