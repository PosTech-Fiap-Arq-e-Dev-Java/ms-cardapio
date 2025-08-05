package com.fiap.ms.cardapio.adapters.in.controller.mapper;

import com.fiap.ms.cardapio.adapters.in.controller.mapper.TagsCardapioDtoMapper;
import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapioDomain.gen.model.TagsCardapioDto;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TagsCardapioDtoMapperTest {

    private TagsCardapioDtoMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(TagsCardapioDtoMapper.class);
    }

    @Test
    void testToDto() {
        TagsCardapioDomain domain = new TagsCardapioDomain(10, "Vegano");

        TagsCardapioDto dto = mapper.toDto(domain);

        assertNotNull(dto);
        assertEquals("10", String.valueOf(dto.getCodigoTags()));
        assertEquals(domain.getNome(), dto.getNome());
    }


    @Test
    void testToDtoList() {
        TagsCardapioDomain tag1 = new TagsCardapioDomain(1, "Vegetariano");
        TagsCardapioDomain tag2 = new TagsCardapioDomain(2, "Sem Glúten");

        List<TagsCardapioDomain> domainList = Arrays.asList(tag1, tag2);

        List<TagsCardapioDto> dtoList = mapper.toDtoList(domainList);

        assertNotNull(dtoList);
        assertEquals(2, dtoList.size());

        assertEquals("1", dtoList.get(0).getCodigoTags());
        assertEquals("Vegetariano", dtoList.get(0).getNome());

        assertEquals("2", dtoList.get(1).getCodigoTags());
        assertEquals("Sem Glúten", dtoList.get(1).getNome());
    }
}

