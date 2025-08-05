package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.ItemTagCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemTagCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.mapper.ItemCardapioEntityMapper;
import com.fiap.ms.cardapio.adapters.out.repository.mapper.TagsCardapioEntityMapper;
import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarTagsCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.InserirTagItemCardapioOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InserirTagItemCardapioAdapter implements InserirTagItemCardapioOutputPort {

    private final BuscarItensCardapioOutputPort buscarItensCardapioOutputPort;
    private final BuscarTagsCardapioOutputPort buscarTagsCardapioOutputPort;
    private final ItemTagCardapioRepository itemTagCardapioRepository;
    private final ItemCardapioEntityMapper mapper;

    private final TagsCardapioEntityMapper tagsCardapioEntityMapper;

    @Override
    @Transactional
    public void inserir(String usuario, Long idItemCardapio, TagsCardapioDomain tags) {
        buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, idItemCardapio).ifPresent(itemDomain -> {
            buscarTagsCardapioOutputPort.buscarPorCodigo(tags.getCodigoTags()).ifPresent(tagDomain -> {
                ItemCardapioEntity itemEntity = mapper.toEntity(itemDomain);
                TagsCardapioEntity tagEntity = tagsCardapioEntityMapper.toEntity(tagDomain);

                ItemTagCardapioEntity novaTag = new ItemTagCardapioEntity();
                novaTag.setItemCardapio(itemEntity);
                novaTag.setCodigoTag(tagEntity);

                itemTagCardapioRepository.save(novaTag);
            });
        });
    }
}


