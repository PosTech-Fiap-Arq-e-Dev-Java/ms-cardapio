package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.ItemCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemTagCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.mapper.ItemCardapioEntityMapper;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BuscarItensCardapioAdapter implements BuscarItensCardapioOutputPort {

    private final ItemCardapioRepository itemCardapioRepository;
    private final ItemCardapioEntityMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public Optional<ItemCardapioDomain> buscarPorUsuarioEIdItemCardapio(String usuario, Long idItemCardapio) {
        return itemCardapioRepository.findByUsuarioAndIdItemCardapio(usuario, idItemCardapio)
                .map(mapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemCardapioDomain> buscarPorUsuario(String usuario) {
        List<ItemCardapioEntity> itens = itemCardapioRepository.findByUsuario(usuario);

        return itens.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ItemCardapioEntity> buscarEntityPorUsuarioEIdItemCardapio(String usuario, Long idItemCardapio) {
        return itemCardapioRepository.findByUsuarioAndIdItemCardapio(usuario, idItemCardapio);
    }

    @Override
    public boolean verificarTagNoItem(ItemCardapioEntity itemEntity, Integer codigoTags) {
        if (itemEntity.getCodigoTags() == null || itemEntity.getCodigoTags().isEmpty()) {
            return false;
        }

        return itemEntity.getCodigoTags().stream()
                .map(ItemTagCardapioEntity::getCodigoTag)
                .filter(Objects::nonNull)
                .anyMatch(tagEntity ->
                        Objects.equals(tagEntity.getCodigo(), (codigoTags))
                );
    }
}
