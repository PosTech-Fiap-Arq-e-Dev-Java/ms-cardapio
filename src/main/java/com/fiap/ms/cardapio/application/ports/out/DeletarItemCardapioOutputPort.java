package com.fiap.ms.cardapio.application.ports.out;

public interface DeletarItemCardapioOutputPort {

    void deletarPorUsuarioEIdItemCardapio(String usuario, Long idItemCardapio);

    void deletarTagPorUsuarioEIdItemCardapio(String usuario, Long idItemCardapio, Integer codigoTags);
}

