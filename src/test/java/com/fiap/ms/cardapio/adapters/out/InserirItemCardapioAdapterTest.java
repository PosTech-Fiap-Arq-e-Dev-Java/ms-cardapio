package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.ItemCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.TagsCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.mapper.ItemCardapioEntityMapper;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class InserirItemCardapioAdapterTest {

    private ItemCardapioRepository itemCardapioRepository;
    private TagsCardapioRepository tagsCardapioRepository;
    private ItemCardapioEntityMapper mapper;

    private InserirItemCardapioAdapter adapter;

    @BeforeEach
    void setUp() {
        itemCardapioRepository = mock(ItemCardapioRepository.class);
        tagsCardapioRepository = mock(TagsCardapioRepository.class);
        mapper = mock(ItemCardapioEntityMapper.class);

        adapter = new InserirItemCardapioAdapter(itemCardapioRepository, tagsCardapioRepository, mapper);
    }

    @Test
    void deveInserirItemComTags() {
        var domain = new ItemCardapioDomain();
        domain.setCodigoTags(List.of(1));

        var entity = new ItemCardapioEntity();
        entity.setCodigoTags(new java.util.ArrayList<>());

        when(mapper.toEntity(domain)).thenReturn(entity);

        var tagEntity = new TagsCardapioEntity();
        when(tagsCardapioRepository.findById(1)).thenReturn(Optional.of(tagEntity));
        adapter.inserir(domain);
        verify(itemCardapioRepository, times(1)).save(entity);
    }
}


