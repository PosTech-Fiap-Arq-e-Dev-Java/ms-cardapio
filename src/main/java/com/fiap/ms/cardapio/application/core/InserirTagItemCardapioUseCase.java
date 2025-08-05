package com.fiap.ms.cardapio.application.core;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.exception.CampoObrigatorioException;
import com.fiap.ms.cardapio.application.core.domain.exception.ItemCardapioNaoEncontradoException;
import com.fiap.ms.cardapio.application.core.domain.exception.MaxTagsExcedidasException;
import com.fiap.ms.cardapio.application.core.domain.exception.TagNaoEncontradaException;
import com.fiap.ms.cardapio.application.ports.in.InserirTagItemCardapioInputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarTagsCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.InserirTagItemCardapioOutputPort;

import java.util.Optional;

public class InserirTagItemCardapioUseCase implements InserirTagItemCardapioInputPort {

    private final BuscarItensCardapioOutputPort buscarItensCardapioOutputPort;
    private final BuscarTagsCardapioOutputPort buscarTagsCardapioOutputPort;
    private final InserirTagItemCardapioOutputPort inserirTagItemCardapioOutputPort;

    public InserirTagItemCardapioUseCase(
            BuscarItensCardapioOutputPort buscarItensCardapioOutputPort,
            BuscarTagsCardapioOutputPort buscarTagsCardapioOutputPort,
            InserirTagItemCardapioOutputPort inserirTagItemCardapioOutputPort
    ) {
        this.buscarItensCardapioOutputPort = buscarItensCardapioOutputPort;
        this.buscarTagsCardapioOutputPort = buscarTagsCardapioOutputPort;
        this.inserirTagItemCardapioOutputPort = inserirTagItemCardapioOutputPort;
    }

    @Override
    public void inserirTag(String usuario, Long idItemCardapio, String codigoTags) {
        Optional.ofNullable(codigoTags)
                .filter(s -> !s.isBlank())
                .orElseThrow(CampoObrigatorioException::new);

        ItemCardapioDomain item = buscarItensCardapioOutputPort
                .buscarPorUsuarioEIdItemCardapio(usuario, idItemCardapio)
                .orElseThrow(() -> new ItemCardapioNaoEncontradoException(usuario, idItemCardapio));

        Optional.ofNullable(item.getCodigoTags())
                .filter(tags -> tags.size() >= 5)
                .ifPresent(tags -> { throw new MaxTagsExcedidasException(); });

        TagsCardapioDomain tag = buscarTagsCardapioOutputPort
                .buscarPorCodigo(Integer.valueOf(codigoTags))
                .orElseThrow(() -> new TagNaoEncontradaException(codigoTags));

        inserirTagItemCardapioOutputPort.inserir(usuario, idItemCardapio, tag);
    }
}