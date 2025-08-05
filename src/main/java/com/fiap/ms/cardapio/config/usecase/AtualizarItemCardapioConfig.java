package com.fiap.ms.cardapio.config.usecase;

import com.fiap.ms.cardapio.application.core.AtualizarItemCardapioUseCase;
import com.fiap.ms.cardapio.application.core.handler.ItemCardapioValidatorHandler;
import com.fiap.ms.cardapio.application.ports.out.AtualizarItemCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarItemCardapioConfig {

    @Bean
    public AtualizarItemCardapioUseCase atualizaItemCardapioUseCase(BuscarItensCardapioOutputPort buscarItensCardapioOutputPort,
                                                                   AtualizarItemCardapioOutputPort atualizarItemCardapioOutputPort,
                                                                   ItemCardapioValidatorHandler itemCardapioValidatorHandler) {
        return new AtualizarItemCardapioUseCase(buscarItensCardapioOutputPort, atualizarItemCardapioOutputPort, itemCardapioValidatorHandler);
    }
}


