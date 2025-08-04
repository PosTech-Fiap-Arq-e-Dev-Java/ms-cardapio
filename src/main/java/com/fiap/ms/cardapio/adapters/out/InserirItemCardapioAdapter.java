package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.ItemCardapioRepository;
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

    @Override
    @Transactional
    public void inserir(ItemCardapioDomain item) {
        var entity = ItemCardapioEntityMapper.INSTANCE.toEntity(item);
        itemCardapioRepository.save(entity);
    }
 }
