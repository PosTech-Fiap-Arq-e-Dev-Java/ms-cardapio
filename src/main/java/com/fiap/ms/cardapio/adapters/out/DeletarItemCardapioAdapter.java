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
    public void deletarPorUsuarioEIdItemCardapio(String usuario, Long idItemCardapio) {
        itemCardapioRepository.findByUsuarioAndIdItemCardapio(usuario, idItemCardapio)
                .ifPresent(itemCardapioRepository::delete);
    }

    @Override
    @Transactional
    public void deletarTagPorUsuarioEIdItemCardapio(String usuario, Long idItemCardapio, Integer codigoTag) {
        itemCardapioRepository.findByUsuarioAndIdItemCardapio(usuario, idItemCardapio).ifPresent(itemCardapio -> {
            itemCardapio.getCodigoTags().stream()
                    .filter(tag -> tag.getCodigoTag().getCodigo().equals(codigoTag))
                    .findFirst()
                    .ifPresent(tagARemover -> {
                        itemCardapio.removeTag(tagARemover);
                        itemCardapioRepository.save(itemCardapio);
                    });
        });
    }
}


