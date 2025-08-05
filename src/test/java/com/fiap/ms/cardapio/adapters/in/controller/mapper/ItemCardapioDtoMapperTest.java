package com.fiap.ms.cardapio.adapters.in.controller.mapper;

import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemTagCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapioDomain.gen.model.AtualizarItemCardapioRequestDto;
import com.fiap.ms.cardapioDomain.gen.model.ItemCardapioDto;
import com.fiap.ms.cardapioDomain.gen.model.NovoItemCardapioDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemCardapioDtoMapperTest {

    private ItemCardapioDtoMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(ItemCardapioDtoMapper.class);
    }

    @Test
    void testToDomainFromEntity() {
        ItemCardapioEntity entity = new ItemCardapioEntity();
        entity.setIdItemCardapio(1L);
        entity.setUsuario("restaurante01");
        entity.setNome("Pizza Margherita");
        entity.setDescricao("Clássica pizza italiana");
        entity.setPreco(BigDecimal.valueOf(29.90));
        entity.setDisponivelLocal(true);

        TagsCardapioEntity tag1 = new TagsCardapioEntity();
        tag1.setCodigo(10);
        TagsCardapioEntity tag2 = new TagsCardapioEntity();
        tag2.setCodigo(20);

        ItemTagCardapioEntity itemTag1 = new ItemTagCardapioEntity();
        itemTag1.setCodigoTag(tag1);

        ItemTagCardapioEntity itemTag2 = new ItemTagCardapioEntity();
        itemTag2.setCodigoTag(tag2);

        entity.setCodigoTags(Arrays.asList(itemTag1, itemTag2));

        ItemCardapioDomain domain = mapper.toDomain(entity);

        assertNotNull(domain);
        assertEquals(entity.getIdItemCardapio(), domain.getIdItemCardapio());
        assertEquals(entity.getUsuario(), domain.getUsuario());
        assertEquals(Arrays.asList(10, 20), domain.getCodigoTags());
    }


    @Test
    void testToDomainFromNovoItemCardapioDto() {
        NovoItemCardapioDto dto = new NovoItemCardapioDto();
        dto.setNome("Lasanha");
        dto.setDescricao("Com molho branco");
        dto.setPreco(39F);
        dto.setDisponivelLocal(false);
        dto.setUsuario("restaurante02");
        dto.setCodigoTags(Arrays.asList("10", "20", "30"));

        ItemCardapioDomain domain = mapper.toDomain(dto);

        assertNotNull(domain);
        assertEquals("restaurante02", domain.getUsuario());
        assertEquals(Arrays.asList(10, 20, 30), domain.getCodigoTags());
    }

    @Test
    void testToDto() {
        ItemCardapioDomain domain = new ItemCardapioDomain();
        domain.setIdItemCardapio(5L);
        domain.setUsuario("parceiro01");
        domain.setNome("Hambúrguer");
        domain.setDescricao("Com cheddar e bacon");
        domain.setPreco(19.90);
        domain.setDisponivelLocal(true);

        ItemCardapioDto dto = mapper.toDto(domain);

        assertNotNull(dto);
        assertEquals(domain.getIdItemCardapio().intValue(), dto.getIdItemCardapio());
        assertEquals(domain.getUsuario(), dto.getUsuario());
        assertEquals(domain.getNome(), dto.getNome());
    }

    @Test
    void testToEntityFromDomain() {

        ItemCardapioDomain domain = new ItemCardapioDomain();
        domain.setUsuario("usuarioTeste");
        domain.setNome("Torta");
        domain.setDescricao("Torta de limão");
        domain.setPreco(15.00);
        domain.setDisponivelLocal(false);

        ItemCardapioEntity entity = mapper.toEntity(domain);

        assertNotNull(entity);
        assertEquals("usuarioTeste", entity.getUsuario());
        assertEquals("Torta", entity.getNome());
    }

    @Test
    void testToDomainFromAtualizarItemCardapioRequestDto() {
        AtualizarItemCardapioRequestDto dto = new AtualizarItemCardapioRequestDto();
        dto.setNome("Atualizado");
        dto.setDescricao("Nova descrição");
        dto.setPreco(22.00F);
        dto.setDisponivelLocal(true);

        ItemCardapioDomain domain = mapper.toDomain(dto);

        assertNotNull(domain);
        assertEquals("Atualizado", domain.getNome());
        assertEquals("Nova descrição", domain.getDescricao());
    }

    @Test
    void testUpdateEntityFromDto() {
        ItemCardapioEntity entity = new ItemCardapioEntity();
        entity.setNome("Antigo");
        entity.setDescricao("Descrição antiga");
        entity.setPreco(BigDecimal.valueOf(10.0));
        entity.setDisponivelLocal(false);

        AtualizarItemCardapioRequestDto dto = new AtualizarItemCardapioRequestDto();
        dto.setNome("Novo nome");
        dto.setPreco(18.5F);

        mapper.updateEntityFromDto(dto, entity);

        assertEquals("Novo nome", entity.getNome());
        assertEquals("Descrição antiga", entity.getDescricao());
        assertEquals(BigDecimal.valueOf(18.5), entity.getPreco());
        assertFalse(entity.getDisponivelLocal());
    }

    @Test
    void testStringListToIntegerList() {
        List<String> input = Arrays.asList("1", "2", "3");
        List<Integer> result = mapper.stringListToIntegerList(input);
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    void testIntegerListToStringList() {
        List<Integer> input = Arrays.asList(7, 8, 9);
        List<String> result = mapper.integerListToStringList(input);
        assertEquals(Arrays.asList("7", "8", "9"), result);
    }

    @Test
    void testStringListToIntegerListWithInvalid() {
        List<String> input = Arrays.asList("10", "", null, "20");
        List<Integer> result = mapper.stringListToIntegerList(input);
        assertEquals(Arrays.asList(10, 20), result);
    }
}
