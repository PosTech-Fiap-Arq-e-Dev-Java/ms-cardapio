package com.fiap.ms.cardapio.application.core.domain;

import java.util.List;

public class ItemCardapioDomain {

    private Long idItemCardapio;
    private String usuario;
    private String nome;
    private List<String> codigoTags;
    private String descricao;
    private Double preco;
    private Boolean disponivelLocal;
    private String fotoPath;

    public ItemCardapioDomain() {
    }

    public ItemCardapioDomain(Long idItemCardapio, String usuario, String nome, List<String> codigoTags,
                              String descricao, Double preco, Boolean disponivelLocal, String fotoPath) {
        this.idItemCardapio = idItemCardapio;
        this.usuario = usuario;
        this.nome = nome;
        this.codigoTags = codigoTags;
        this.descricao = descricao;
        this.preco = preco;
        this.disponivelLocal = disponivelLocal;
        this.fotoPath = fotoPath;
    }

    public Long getIdItemCardapio() {
        return idItemCardapio;
    }

    public void setIdItemCardapio(Long idItemCardapio) {
        this.idItemCardapio = idItemCardapio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getCodigoTags() {
        return codigoTags;
    }

    public void setCodigoTags(List<String> codigoTags) {
        this.codigoTags = codigoTags;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Boolean getDisponivelLocal() {
        return disponivelLocal;
    }

    public void setDisponivelLocal(Boolean disponivelLocal) {
        this.disponivelLocal = disponivelLocal;
    }

    public String getFotoPath() {
        return fotoPath;
    }

    public void setFotoPath(String fotoPath) {
        this.fotoPath = fotoPath;
    }
}

