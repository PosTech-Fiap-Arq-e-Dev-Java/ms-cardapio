package com.fiap.ms.cardapio.adapters.out.repository.entity;

import jakarta.persistence.*;
        import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_item_tag_cardapio")
public class ItemTagCardapioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTagItem;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_cardapio_id", nullable = false)
    private ItemCardapioEntity itemCardapio;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "tags_cardapio_id", nullable = false)
    private TagsCardapioEntity codigoTag;
}
