package com.fiap.ms.cardapio.application.ports.in;

public interface DeletarItemCardapioInputPort {

    void deletarPorUsuarioEIdItemCardapio(String usuario, Long idItemCardapio);

    void deletarTagPorUsuarioEIdItemCardapio(String usuario, Long idItemCardapio, Integer codigoTags);
    ;
}

