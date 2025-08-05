package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.ItemCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.TagsCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemTagCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.mapper.ItemCardapioEntityMapper;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.ports.out.InserirItemCardapioOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InserirItemCardapioAdapter implements InserirItemCardapioOutputPort {

    private final ItemCardapioRepository itemCardapioRepository;
    private final TagsCardapioRepository tagsCardapioRepository;
    private final ItemCardapioEntityMapper mapper;

    @Override
    @Transactional
    public void inserir(ItemCardapioDomain item) {
        var entity = mapper.toEntity(item);

        entity.getCodigoTags().clear();

        for (Integer codigoTag : item.getCodigoTags()) {
            tagsCardapioRepository.findById(codigoTag).ifPresent(tagEntity -> {
                ItemTagCardapioEntity itemTag = new ItemTagCardapioEntity();
                itemTag.setCodigoTag(tagEntity);
                entity.addTag(itemTag);
            });
        }

        itemCardapioRepository.save(entity);
    }
}