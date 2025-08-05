package com.fiap.ms.cardapio.adapters.out.repository.mapper;

import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class TagsCardapioEntityMapperTest {

    private TagsCardapioEntityMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(TagsCardapioEntityMapper.class);
    }

    @Test
    void testToDomain() {
        TagsCardapioEntity entity = new TagsCardapioEntity();
        entity.setCodigo(123);
        entity.setNome("Teste Tag");

        TagsCardapioDomain domain = mapper.toDomain(entity);

        assertNotNull(domain);
        assertEquals(123, domain.getCodigoTags());
        assertEquals("Teste Tag", domain.getNome());
    }

    @Test
    void testToEntity() {
        TagsCardapioDomain domain = new TagsCardapioDomain();
        domain.setCodigoTags(456);
        domain.setNome("Outra Tag");

        TagsCardapioEntity entity = mapper.toEntity(domain);

        assertNotNull(entity);
        assertEquals(456, entity.getCodigo());
        assertEquals("Outra Tag", entity.getNome());
    }
}

