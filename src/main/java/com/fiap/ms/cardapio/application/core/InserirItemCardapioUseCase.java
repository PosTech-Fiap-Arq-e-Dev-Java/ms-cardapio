package com.fiap.ms.cardapio.application.core;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.exception.NomeItemCardapioDuplicadoException;
import com.fiap.ms.cardapio.application.core.domain.exception.TagNaoEncontradaException;
import com.fiap.ms.cardapio.application.core.handler.ItemCardapioValidatorHandler;
import com.fiap.ms.cardapio.application.ports.in.InserirItemCardapioInputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarTagsCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.InserirItemCardapioOutputPort;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class InserirItemCardapioUseCase implements InserirItemCardapioInputPort {

    private final InserirItemCardapioOutputPort inserirItemCardapioOutputPort;
    private final BuscarItensCardapioOutputPort buscarItensCardapioOutputPort;
    private final BuscarTagsCardapioOutputPort buscarTagsCardapioOutputPort;
    private final ItemCardapioValidatorHandler itemCardapioValidatorHandler;

    public InserirItemCardapioUseCase(
            InserirItemCardapioOutputPort inserirItemCardapioOutputPort,
            BuscarItensCardapioOutputPort buscarItensCardapioOutputPort,
            BuscarTagsCardapioOutputPort buscarTagsCardapioOutputPort,
            ItemCardapioValidatorHandler itemCardapioValidatorHandler) {
        this.inserirItemCardapioOutputPort = inserirItemCardapioOutputPort;
        this.buscarItensCardapioOutputPort = buscarItensCardapioOutputPort;
        this.buscarTagsCardapioOutputPort = buscarTagsCardapioOutputPort;
        this.itemCardapioValidatorHandler = itemCardapioValidatorHandler;
    }

    @Override
    public void inserir(ItemCardapioDomain novoItem) {
        itemCardapioValidatorHandler.validarCamposObrigatoriosItemCardapio(novoItem);

        verificarDuplicidadeDeNome(novoItem);
        verificarExistenciaTags(novoItem.getCodigoTags());

        inserirItemCardapioOutputPort.inserir(novoItem);
    }

    private void verificarDuplicidadeDeNome(ItemCardapioDomain novoItem) {
        List<ItemCardapioDomain> itensDoUsuario = Optional.ofNullable(
                buscarItensCardapioOutputPort.buscarPorUsuario(novoItem.getUsuario())
        ).orElseGet(Collections::emptyList);

        boolean nomeDuplicado = itensDoUsuario.stream()
                .anyMatch(item -> item.getNome().equalsIgnoreCase(novoItem.getNome()));

        if (nomeDuplicado) {
            throw new NomeItemCardapioDuplicadoException(novoItem.getUsuario(), novoItem.getNome());
        }
    }

    private void verificarExistenciaTags(List<Integer> codigoTags) {
        for (Integer codigoTag : codigoTags) {
            boolean tagExiste = buscarTagsCardapioOutputPort.buscarPorCodigo(codigoTag).isPresent();
            if (!tagExiste) {
                throw new TagNaoEncontradaException(codigoTags.toString());
            }
        }
    }

}



