package com.fiap.ms.cardapio.config.usecase;

import com.fiap.ms.cardapio.application.core.DeletarItemCardapioUseCase;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.DeletarItemCardapioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarItemCardapioConfig {

    @Bean
    public DeletarItemCardapioUseCase deletarItemCardapioUseCase(DeletarItemCardapioOutputPort deletarItemCardapioOutputPort,
                                                                 BuscarItensCardapioOutputPort buscarItensCardapioOutputPort) {
        return new DeletarItemCardapioUseCase(deletarItemCardapioOutputPort, buscarItensCardapioOutputPort);
    }
}



