package com.fiap.ms.cardapio.application.core.domain;

import com.fiap.ms.cardapio.application.core.domain.enums.TagsCardapioEnum;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TagsCardapioEnumTest {

    @Test
    void testGetters() {
        TagsCardapioEnum tag = TagsCardapioEnum.PRATO_FEITO;
        assertEquals(1, tag.getCodigo());
        assertEquals("1", tag.getCodigoString());
        assertEquals("Prato Feito", tag.getDescricao());
        assertEquals("Prato Feito", tag.toString());
    }

    @Test
    void testFromCodigo_Valid() {
        TagsCardapioEnum tag = TagsCardapioEnum.fromCodigo(4);
        assertEquals(TagsCardapioEnum.CARNE, tag);
    }

    @Test
    void testFromCodigo_Invalid() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            TagsCardapioEnum.fromCodigo(99);
        });
        assertTrue(exception.getMessage().contains("Código inválido para TagsCardapioEnum"));
    }

    @Test
    void testFromDescricao_Valid() {
        TagsCardapioEnum tag = TagsCardapioEnum.fromDescricao("aves");
        assertEquals(TagsCardapioEnum.AVES, tag);

        TagsCardapioEnum tag2 = TagsCardapioEnum.fromDescricao("  Peixes e frutos do mar ");
        assertEquals(TagsCardapioEnum.PEIXES_E_FRUTOS_DO_MAR, tag2);
    }

    @Test
    void testFromDescricao_Invalid() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            TagsCardapioEnum.fromDescricao("Descrição inexistente");
        });
        assertTrue(exception.getMessage().contains("Descrição inválida para TagsCardapioEnum"));
    }

    @Test
    void testFromDescricao_Null() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            TagsCardapioEnum.fromDescricao(null);
        });
        assertTrue(exception.getMessage().contains("Descrição inválida para TagsCardapioEnum"));
    }

    @Test
    void testGetDescricoes() {
        List<String> descricoes = TagsCardapioEnum.getDescricoes();
        assertNotNull(descricoes);
        assertTrue(descricoes.contains("Prato Feito"));
        assertTrue(descricoes.contains("Integral"));
        assertEquals(TagsCardapioEnum.values().length, descricoes.size());
    }
}

