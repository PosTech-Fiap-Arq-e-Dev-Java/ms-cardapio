package com.fiap.ms.cardapio.application.core.domain;

public class TagsCardapioDomain {

    private String codigoTags;
    private String nome;

    public TagsCardapioDomain() {}

    public TagsCardapioDomain(String codigoTags, String nome) {
        this.codigoTags = codigoTags;
        this.nome = nome;
    }

    public String getCodigoTags() {
        return codigoTags;
    }

    public void setCodigoTags(String codigoTags) {
        this.codigoTags = codigoTags;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

