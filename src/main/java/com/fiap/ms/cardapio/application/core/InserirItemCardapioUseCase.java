package com.fiap.ms.cardapio.application.core;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.exception.NomeItemCardapioDuplicadoException;
import com.fiap.ms.cardapio.application.core.handler.ItemCardapioValidatorHandler;
import com.fiap.ms.cardapio.application.ports.in.InserirItemCardapioInputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.InserirItemCardapioOutputPort;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class InserirItemCardapioUseCase implements InserirItemCardapioInputPort {

    private final InserirItemCardapioOutputPort inserirItemCardapioOutputPort;
    private final BuscarItensCardapioOutputPort buscarItensCardapioOutputPort;
    private final ItemCardapioValidatorHandler itemCardapioValidatorHandler;

    public InserirItemCardapioUseCase(InserirItemCardapioOutputPort inserirItemCardapioOutputPort,
                                      BuscarItensCardapioOutputPort buscarItensCardapioOutputPort,
                                      ItemCardapioValidatorHandler itemCardapioValidatorHandler) {
        this.inserirItemCardapioOutputPort = inserirItemCardapioOutputPort;
        this.buscarItensCardapioOutputPort = buscarItensCardapioOutputPort;
        this.itemCardapioValidatorHandler = itemCardapioValidatorHandler;
    }

    @Override
    public void inserir(ItemCardapioDomain novoItem) {
        itemCardapioValidatorHandler.validarCamposObrigatoriosItemCardapio(novoItem);

        List<ItemCardapioDomain> itens = Optional.ofNullable(buscarItensCardapioOutputPort.buscarPorUsuario(novoItem.getUsuario()))
                .orElseGet(Collections::emptyList);

        Optional<ItemCardapioDomain> existente = itens.stream()
                .filter(item -> item.getNome().equalsIgnoreCase(novoItem.getNome()))
                .findAny();

        if (existente.isPresent()) {
            throw new NomeItemCardapioDuplicadoException(novoItem.getUsuario(), novoItem.getNome());
        }

        inserirItemCardapioOutputPort.inserir(novoItem);
    }

}


