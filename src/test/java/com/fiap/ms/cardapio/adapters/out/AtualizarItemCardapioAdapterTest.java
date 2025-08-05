package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.ItemCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class AtualizarItemCardapioAdapterTest {

    private ItemCardapioRepository itemCardapioRepository;
    private AtualizarItemCardapioAdapter atualizarItemCardapioAdapter;

    @BeforeEach
    void setUp() {
        itemCardapioRepository = mock(ItemCardapioRepository.class);
        atualizarItemCardapioAdapter = new AtualizarItemCardapioAdapter(itemCardapioRepository);
    }

    @Test
    void deveAtualizarItemCardapio() {
        ItemCardapioEntity entity = new ItemCardapioEntity();
        entity.setIdItemCardapio(1L);
        entity.setNome("Marmita");
        entity.setDescricao("Promoção do dia");
        atualizarItemCardapioAdapter.atualizar(entity);

        verify(itemCardapioRepository, times(1)).save(entity);
    }
}
