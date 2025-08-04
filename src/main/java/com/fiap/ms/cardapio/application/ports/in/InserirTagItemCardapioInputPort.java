package com.fiap.ms.cardapio.application.ports.in;

public interface InserirTagItemCardapioInputPort {

    void inserirTag(String usuario, Long idItemCardapio, String codigoTags);
}

