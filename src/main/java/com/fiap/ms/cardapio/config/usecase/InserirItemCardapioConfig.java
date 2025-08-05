package com.fiap.ms.cardapio.config.usecase;

import com.fiap.ms.cardapio.application.core.InserirItemCardapioUseCase;
import com.fiap.ms.cardapio.application.core.handler.ItemCardapioValidatorHandler;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarTagsCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.InserirItemCardapioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InserirItemCardapioConfig {

    @Bean
    public InserirItemCardapioUseCase inserirItemCardapioUseCase(InserirItemCardapioOutputPort inserirItemCardapioOutputPort,
                                                                 BuscarItensCardapioOutputPort buscarItensCardapioOutputPort,
                                                                 BuscarTagsCardapioOutputPort buscarTagsCardapioOutputPort,
                                                                 ItemCardapioValidatorHandler itemCardapioValidatorHandler) {

        return new InserirItemCardapioUseCase(inserirItemCardapioOutputPort, buscarItensCardapioOutputPort, buscarTagsCardapioOutputPort, itemCardapioValidatorHandler);
    }
}

