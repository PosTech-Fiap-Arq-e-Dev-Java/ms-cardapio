package com.fiap.ms.cardapio.config.usecase;

import com.fiap.ms.cardapio.application.core.ListarTagsCardapioUseCase;
import com.fiap.ms.cardapio.application.ports.in.ListarTagsCardapioInputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarTagsCardapioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListarTagsCardapioConfig {

    @Bean
    public ListarTagsCardapioUseCase listarTagsCardapioUseCase(BuscarTagsCardapioOutputPort buscarTagsCardapioOutputPort) {
        return new ListarTagsCardapioUseCase(buscarTagsCardapioOutputPort);
    }
}

