package com.fiap.ms.cardapio.application.core;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.exception.ItemCardapioNaoEncontradoException;
import com.fiap.ms.cardapio.application.core.domain.exception.TagNaoEncontradaException;
import com.fiap.ms.cardapio.application.ports.in.InserirTagItemCardapioInputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarTagsCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.InserirTagItemCardapioOutputPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InserirTagItemCardapioUseCase implements InserirTagItemCardapioInputPort {

    private final BuscarItensCardapioOutputPort buscarItensCardapioOutputPort;
    private final BuscarTagsCardapioOutputPort buscarTagsCardapioOutputPort;
    private final InserirTagItemCardapioOutputPort inserirTagItemCardapioOutputPort;

    @Override
    public void inserirTag(String usuario, Long idItemCardapio, String codigoTags) {
        ItemCardapioDomain item = buscarItensCardapioOutputPort
                .buscarPorUsuarioEId(usuario, idItemCardapio)
                .orElseThrow(() -> new ItemCardapioNaoEncontradoException(usuario, idItemCardapio));

        TagsCardapioDomain tags = buscarTagsCardapioOutputPort
                .buscarTodas()
                .stream()
                .filter(t -> t.getCodigoTags().equals(codigoTags))
                .findFirst()
                .orElseThrow(() -> new TagNaoEncontradaException(codigoTags));

        inserirTagItemCardapioOutputPort.inserir(usuario, idItemCardapio, tags);
    }
}

