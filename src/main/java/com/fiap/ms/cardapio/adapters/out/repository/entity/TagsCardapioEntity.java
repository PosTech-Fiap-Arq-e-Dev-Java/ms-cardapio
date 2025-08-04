package com.fiap.ms.cardapio.adapters.out.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_tag_cardapio")
public class TagsCardapioEntity {

    @Id
    @Column(name = "codigo", nullable = false, unique = true)
    private String codigo;

    @Column(name = "nome", nullable = false)
    private String nome;
}


