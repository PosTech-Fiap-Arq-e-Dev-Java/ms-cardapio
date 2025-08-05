package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.ItemCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.mapper.ItemCardapioEntityMapper;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AtualizarItemCardapioAdapterTest {
/*
    private ItemCardapioRepository itemCardapioRepository;
    private AtualizarItemCardapioAdapter atualizarItemCardapioAdapter;

    @BeforeEach
    void setUp() {
        itemCardapioRepository = mock(ItemCardapioRepository.class);
        atualizarItemCardapioAdapter = new AtualizarItemCardapioAdapter(itemCardapioRepository);
    }

    @Test
    void deveAtualizarItemCardapio() {
        // Arrange
        ItemCardapioDomain domain = new ItemCardapioDomain();
        domain.setNome("Pizza Margherita");
        domain.setDescricao("Clássica com manjericão");
        domain.setPreco(40.00);
        domain.setDisponivelLocal(true);
        domain.setFotoPath("pizza.jpg");

        ItemCardapioEntity entity = ItemCardapioEntityMapper.INSTANCE.toEntity(domain);

        atualizarItemCardapioAdapter.atualizar(domain);

        ArgumentCaptor<ItemCardapioEntity> captor = ArgumentCaptor.forClass(ItemCardapioEntity.class);
        verify(itemCardapioRepository, times(1)).save(captor.capture());

        ItemCardapioEntity salvo = captor.getValue();
        assertEquals(domain.getNome(), salvo.getNome());
        assertEquals(domain.getDescricao(), salvo.getDescricao());
        assertEquals(BigDecimal.valueOf(domain.getPreco()), salvo.getPreco());
        assertEquals(domain.getDisponivelLocal(), salvo.getDisponivelLocal());
        assertEquals(domain.getFotoPath(), salvo.getFotoPath());
    }

 */
}
