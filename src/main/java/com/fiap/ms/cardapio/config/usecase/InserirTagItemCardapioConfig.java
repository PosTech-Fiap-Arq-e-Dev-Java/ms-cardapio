package com.fiap.ms.cardapio.config.usecase;

import com.fiap.ms.cardapio.application.core.InserirTagItemCardapioUseCase;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarTagsCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.InserirTagItemCardapioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InserirTagItemCardapioConfig {

    @Bean
    public InserirTagItemCardapioUseCase inserirTagItemCardapioUseCase(BuscarItensCardapioOutputPort buscarItensCardapioOutputPort,
                                                                       BuscarTagsCardapioOutputPort buscarTagsCardapioOutputPort,
                                                                       InserirTagItemCardapioOutputPort inserirTagItemCardapioOutputPort) {
        return new InserirTagItemCardapioUseCase(buscarItensCardapioOutputPort, buscarTagsCardapioOutputPort, inserirTagItemCardapioOutputPort);
    }
}
