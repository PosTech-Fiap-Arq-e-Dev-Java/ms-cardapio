package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.TagsCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapio.application.ports.out.BuscarTagsCardapioOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BuscarTagsCardapioAdapter implements BuscarTagsCardapioOutputPort {

    private final TagsCardapioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<TagsCardapioDomain> buscarTodas() {
        return repository.findAllByOrderByCodigoAsc()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TagsCardapioDomain> buscarPorCodigo(Integer codigo) {
        return repository.findByCodigo(codigo)
                .map(this::toDomain);
    }

    private TagsCardapioDomain toDomain(TagsCardapioEntity entity) {
        TagsCardapioDomain domain = new TagsCardapioDomain();
        domain.setCodigoTags(entity.getCodigo());
        domain.setNome(entity.getNome());
        return domain;
    }
}