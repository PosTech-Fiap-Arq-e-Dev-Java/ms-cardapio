package com.fiap.ms.cardapio.application.core.domain;

public class TagsCardapioDomain {

    private Integer codigoTags;
    private String nome;

    public TagsCardapioDomain() {}

    public TagsCardapioDomain(Integer codigoTags, String nome) {
        this.codigoTags = codigoTags;
        this.nome = nome;
    }

    public Integer getCodigoTags() {
        return codigoTags;
    }

    public void setCodigoTags(Integer codigoTags) {
        this.codigoTags = codigoTags;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

