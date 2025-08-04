package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapio.adapters.out.repository.TagsCardapioRepository;
import com.fiap.ms.cardapio.application.ports.out.BuscarTagsCardapioOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BuscarTagsCardapioAdapter implements BuscarTagsCardapioOutputPort {

    private final TagsCardapioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<TagsCardapioDomain> buscarTodas() {
        return repository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private TagsCardapioDomain toDomain(TagsCardapioEntity entity) {
        return new TagsCardapioDomain(entity.getCodigo(), entity.getNome());
    }
}


