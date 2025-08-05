package com.fiap.ms.cardapio.adapters.out.repository.mapper;

import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemTagCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapioDomain.gen.model.ItemCardapioDto;
import com.fiap.ms.cardapioDomain.gen.model.TagsCardapioDto;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemCardapioEntityMapperTest {

    private ItemCardapioEntityMapper mapper;

    @BeforeEach
    void setup() {
        mapper = Mappers.getMapper(ItemCardapioEntityMapper.class);
    }

    @Test
    void testToDomain_withCodigoTags_shouldMapCorrectly() {
        ItemCardapioEntity entity = new ItemCardapioEntity();
        entity.setIdItemCardapio(1L);
        entity.setUsuario("usuario1");
        entity.setNome("Prato Teste");
        entity.setDescricao("Descricao Teste");
        entity.setPreco(BigDecimal.valueOf(20));
        entity.setDisponivelLocal(true);

        TagsCardapioEntity tag1 = new TagsCardapioEntity();
        tag1.setCodigo(100);
        tag1.setNome("Vegano");

        TagsCardapioEntity tag2 = new TagsCardapioEntity();
        tag2.setCodigo(200);
        tag2.setNome("Sem Glúten");

        ItemTagCardapioEntity itemTag1 = new ItemTagCardapioEntity();
        itemTag1.setCodigoTag(tag1);

        ItemTagCardapioEntity itemTag2 = new ItemTagCardapioEntity();
        itemTag2.setCodigoTag(tag2);

        entity.setCodigoTags(Arrays.asList(itemTag1, itemTag2));

        ItemCardapioDomain domain = mapper.toDomain(entity);

        assertNotNull(domain);
        assertEquals(entity.getIdItemCardapio(), domain.getIdItemCardapio());
        assertEquals(entity.getUsuario(), domain.getUsuario());
        assertEquals(2, domain.getCodigoTags().size());
        assertTrue(domain.getCodigoTags().containsAll(List.of(100, 200)));
    }

    @Test
    void testToEntity_shouldMapBasicFields() {
        ItemCardapioDomain domain = new ItemCardapioDomain();
        domain.setIdItemCardapio(1L);
        domain.setUsuario("usuario2");
        domain.setNome("Prato Domain");
        domain.setDescricao("Descricao Domain");
        domain.setPreco(15.0);
        domain.setDisponivelLocal(false);

        ItemCardapioEntity entity = mapper.toEntity(domain);

        assertNotNull(entity);
        assertEquals(domain.getUsuario(), entity.getUsuario());
        assertEquals(domain.getNome(), entity.getNome());
        assertEquals(domain.getDescricao(), entity.getDescricao());
        assertEquals(BigDecimal.valueOf(domain.getPreco()), entity.getPreco());
        assertEquals(domain.getDisponivelLocal(), entity.getDisponivelLocal());
    }

    @Test
    void testToDto_shouldMapTagsCorrectly() {
        ItemCardapioEntity entity = getItemCardapio();

        ItemCardapioDto dto = mapper.toDto(entity);

        assertNotNull(dto);
        assertEquals(entity.getIdItemCardapio().intValue(), dto.getIdItemCardapio()); // pode ser int vs long
        assertEquals(entity.getUsuario(), dto.getUsuario());
        assertEquals(entity.getNome(), dto.getNome());
        assertEquals(2, dto.getTags().size());

        TagsCardapioDto dtoTag1 = dto.getTags().get(0);
        assertEquals("101", dtoTag1.getCodigoTags());
        assertEquals("Tag 1", dtoTag1.getNome());

        TagsCardapioDto dtoTag2 = dto.getTags().get(1);
        assertEquals("202", dtoTag2.getCodigoTags());
        assertEquals("Tag 2", dtoTag2.getNome());
    }

    @NotNull
    private static ItemCardapioEntity getItemCardapio() {
        TagsCardapioEntity tag1 = new TagsCardapioEntity();
        tag1.setCodigo(101);
        tag1.setNome("Tag 1");

        TagsCardapioEntity tag2 = new TagsCardapioEntity();
        tag2.setCodigo(202);
        tag2.setNome("Tag 2");

        ItemTagCardapioEntity itemTag1 = new ItemTagCardapioEntity();
        itemTag1.setCodigoTag(tag1);

        ItemTagCardapioEntity itemTag2 = new ItemTagCardapioEntity();
        itemTag2.setCodigoTag(tag2);

        ItemCardapioEntity entity = new ItemCardapioEntity();
        entity.setIdItemCardapio(10L);
        entity.setUsuario("usuarioDto");
        entity.setNome("Nome DTO");
        entity.setDescricao("Descricao DTO");
        entity.setPreco(BigDecimal.valueOf(30));
        entity.setDisponivelLocal(true);
        entity.setCodigoTags(Arrays.asList(itemTag1, itemTag2));
        return entity;
    }

    @Test
    void testMapTags_withNullInput_shouldReturnEmptyList() {
        List<TagsCardapioDto> tags = mapper.mapTags(null);
        assertNotNull(tags);
        assertTrue(tags.isEmpty());
    }

    @Test
    void testMapTag_shouldMapCorrectly() {
        TagsCardapioEntity tag = new TagsCardapioEntity();
        tag.setCodigo(555);
        tag.setNome("Teste Tag");

        ItemTagCardapioEntity itemTag = new ItemTagCardapioEntity();
        itemTag.setCodigoTag(tag);

        TagsCardapioDto dto = mapper.mapTag(itemTag);

        assertNotNull(dto);
        assertEquals("555", dto.getCodigoTags());
        assertEquals("Teste Tag", dto.getNome());
    }
}

