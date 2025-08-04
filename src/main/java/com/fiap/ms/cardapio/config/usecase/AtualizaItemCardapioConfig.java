package com.fiap.ms.cardapio.config.usecase;

import com.fiap.ms.cardapio.application.core.AtualizaItemCardapioUseCase;
import com.fiap.ms.cardapio.application.core.handler.ItemCardapioValidatorHandler;
import com.fiap.ms.cardapio.application.ports.out.AtualizarItemCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizaItemCardapioConfig {

    @Bean
    public AtualizaItemCardapioUseCase atualizaItemCardapioUseCase(BuscarItensCardapioOutputPort buscarItensCardapioOutputPort,
                                                                   AtualizarItemCardapioOutputPort atualizarItemCardapioOutputPort,
                                                                   ItemCardapioValidatorHandler itemCardapioValidatorHandler) {
        return new AtualizaItemCardapioUseCase(buscarItensCardapioOutputPort, atualizarItemCardapioOutputPort, itemCardapioValidatorHandler);
    }
}


