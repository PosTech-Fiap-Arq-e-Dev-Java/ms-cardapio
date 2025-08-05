package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.ItemCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.Mockito.*;

class InserirItemCardapioAdapterTest {

    @Mock
    private ItemCardapioRepository itemCardapioRepository;

    @InjectMocks
    private InserirItemCardapioAdapter adapter;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveInserirItemCardapioChamandoRepositorio() {
        ItemCardapioDomain itemDomain = new ItemCardapioDomain();

        ItemCardapioEntity itemEntity = new ItemCardapioEntity();

        adapter.inserir(itemDomain);

        verify(itemCardapioRepository, times(1)).save(any(ItemCardapioEntity.class));
    }
}

