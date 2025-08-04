package com.fiap.ms.cardapio.application.ports.in;

public interface DeletarItemCardapioInputPort {

    void deletarPorUsuarioEId(String usuario, Long idItemCardapio);

    void deletarTagPorUsuarioEId(String usuario, Long idItemCardapio, String codigoTags);


}

