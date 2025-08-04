package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.ItemCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.ItemTagCardapioRepository;
import com.fiap.ms.cardapio.application.ports.out.DeletarItemCardapioOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor
public class DeletarItemCardapioAdapter implements DeletarItemCardapioOutputPort {

    private final ItemCardapioRepository itemCardapioRepository;
    private final ItemTagCardapioRepository itemTagCardapioRepository;

    @Override
    @Transactional
    public void deletarPorUsuarioEId(String usuario, Long idItemCardapio) {
        itemCardapioRepository.findByUsuarioAndId(usuario, idItemCardapio)
                .ifPresent(itemCardapioRepository::delete);
    }

    @Override
    @Transactional
    public void deletarTagPorUsuarioEId(String usuario, Long idItemCardapio, String codigoTags) {
        itemTagCardapioRepository.findByItemCardapioIdAndTagIdAndItemCardapioUsuario(idItemCardapio, codigoTags, usuario)
                .ifPresent(itemTagCardapioRepository::delete);
    }
}


