package com.fiap.ms.cardapio.config.usecase;

import com.fiap.ms.cardapio.application.core.BuscarItensCardapioUseCase;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarItensCardapioConfig {

    @Bean
    public BuscarItensCardapioUseCase buscarItensCardapioUseCase(BuscarItensCardapioOutputPort buscarItensCardapioOutputPort) {
        return new BuscarItensCardapioUseCase(buscarItensCardapioOutputPort);
    }
}

