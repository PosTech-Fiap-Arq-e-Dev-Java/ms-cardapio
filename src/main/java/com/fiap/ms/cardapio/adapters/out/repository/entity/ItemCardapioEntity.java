package com.fiap.ms.cardapio.adapters.out.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_item_cardapio")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"usuario", "nome"}))
public class ItemCardapioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemCardapio;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @Column(name = "disponivel_local", nullable = false)
    private Boolean disponivelLocal;

    @Column(name = "foto_path")
    private String fotoPath;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @OneToMany(mappedBy = "itemCardapio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemTagCardapioEntity> codigoTags = new ArrayList<>();

    public void addTag(ItemTagCardapioEntity tagRelacionamento) {
        tagRelacionamento.setItemCardapio(this);
        this.codigoTags.add(tagRelacionamento);
    }

    public void removeTag(ItemTagCardapioEntity tagRelacionamento) {
        tagRelacionamento.setItemCardapio(null);
        this.codigoTags.remove(tagRelacionamento);
    }
}


