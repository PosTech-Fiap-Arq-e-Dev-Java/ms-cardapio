package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.ItemCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.mapper.ItemCardapioEntityMapper;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.ports.out.AtualizarItemCardapioOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AtualizarItemCardapioAdapter implements AtualizarItemCardapioOutputPort {

    private final ItemCardapioRepository itemCardapioRepository;

    @Override
    @Transactional
    public void atualizar(ItemCardapioDomain itemCardapioDomain) {
        var entity = ItemCardapioEntityMapper.INSTANCE.toEntity(itemCardapioDomain);
        itemCardapioRepository.save(entity);
    }
}
