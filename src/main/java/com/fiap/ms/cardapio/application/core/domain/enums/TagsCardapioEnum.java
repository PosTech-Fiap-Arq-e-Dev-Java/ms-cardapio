package com.fiap.ms.cardapio.application.core.domain.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum TagsCardapioEnum {

    PRATO_FEITO(1, "Prato Feito"),
    PRATO_EXECUTIVO(2, "Prato Executivo"),
    MASSAS(3, "Massas"),
    CARNE(4, "Carne"),
    AVES(5, "Aves"),
    PEIXES_E_FRUTOS_DO_MAR(6, "Peixes e Frutos do Mar"),
    DOCES(7, "Doces"),
    BEBIDAS(8, "Bebidas"),
    SANDUICHES(9, "Sanduíches"),
    ACOMPANHAMENTOS(10, "Acompanhamentos"),
    SALGADOS(11, "Salgados"),
    SAUDAVEL(12, "Saudável"),
    SEM_GLUTEN(13, "Sem Glúten"),
    SEM_LACTOSE(14, "Sem Lactose"),
    PAES(15, "Pães"),
    GRELHADO(16, "Grelhado"),
    FIT(17, "Fit"),
    REGIONAL(18, "Regional"),
    COM_QUEIJO(19, "Com Queijo"),
    ARTESANAL(20, "Artesanal"),
    GRANDE(21, "Tamanho Grande"),
    MEDIO(22, "Tamanho Médio"),
    PEQUENO(23, "Tamanho Pequeno"),
    MARMITA(24, "Marmita"),
    INTEGRAL(25, "Integral");

    private final int codigo;
    private final String descricao;

    TagsCardapioEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getCodigoString() {
        return String.valueOf(codigo);
    }

    public String getDescricao() {
        return descricao;
    }

    public static TagsCardapioEnum fromCodigo(int codigo) {
        return Arrays.stream(TagsCardapioEnum.values())
                .filter(tag -> tag.getCodigo() == codigo)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Código inválido para TagsCardapioEnum: " + codigo));
    }

    public static TagsCardapioEnum fromDescricao(String descricao) {
        String descTrim = descricao == null ? "" : descricao.trim();
        return Arrays.stream(TagsCardapioEnum.values())
                .filter(tag -> tag.getDescricao().equalsIgnoreCase(descTrim))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Descrição inválida para TagsCardapioEnum: " + descricao));
    }

    public static List<String> getDescricoes() {
        return Arrays.stream(TagsCardapioEnum.values())
                .map(TagsCardapioEnum::getDescricao)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return descricao;
    }
}

