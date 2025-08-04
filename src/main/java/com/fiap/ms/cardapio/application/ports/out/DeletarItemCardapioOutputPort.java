package com.fiap.ms.cardapio.application.ports.out;

public interface DeletarItemCardapioOutputPort {

    void deletarPorUsuarioEId(String usuario, Long idItemCardapio);

    void deletarTagPorUsuarioEId(String usuario, Long idItemCardapio, String codigoTags);
}

