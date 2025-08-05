package com.fiap.ms.cardapio.application.core;

import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.exception.ItemCardapioNaoEncontradoException;
import com.fiap.ms.cardapio.application.core.handler.ItemCardapioValidatorHandler;
import com.fiap.ms.cardapio.application.ports.out.AtualizarItemCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AtualizarItemCardapioUseCaseTest {

    @Mock
    private BuscarItensCardapioOutputPort buscarItensCardapioOutputPort;

    @Mock
    private AtualizarItemCardapioOutputPort atualizarItemCardapioOutputPort;

    @Mock
    private ItemCardapioValidatorHandler itemCardapioValidatorHandler;

    @InjectMocks
    private AtualizarItemCardapioUseCase atualizarItemCardapioUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void atualizar_deveAtualizarItemQuandoExistir() {
        String usuario = "usuario1";
        Long idItem = 1L;

        ItemCardapioDomain itemAtualizado = new ItemCardapioDomain();
        itemAtualizado.setNome("Novo Nome");
        itemAtualizado.setDescricao("Nova descrição");
        itemAtualizado.setPreco(50.0);
        itemAtualizado.setDisponivelLocal(true);
        itemAtualizado.setFotoPath("/novo/caminho/foto.jpg");

        ItemCardapioEntity itemEntity = new ItemCardapioEntity();
        itemEntity.setNome("Nome Antigo");
        itemEntity.setDescricao("Descrição Antiga");
        itemEntity.setPreco(BigDecimal.valueOf(30));
        itemEntity.setDisponivelLocal(false);
        itemEntity.setFotoPath("/caminho/antigo.jpg");

        when(buscarItensCardapioOutputPort.buscarEntityPorUsuarioEIdItemCardapio(usuario, idItem))
                .thenReturn(Optional.of(itemEntity));

        atualizarItemCardapioUseCase.atualizar(usuario, idItem, itemAtualizado);

        verify(itemCardapioValidatorHandler).validarCamposObrigatoriosAtualizarItemCardapio(itemAtualizado);
        verify(buscarItensCardapioOutputPort).buscarEntityPorUsuarioEIdItemCardapio(usuario, idItem);
        verify(atualizarItemCardapioOutputPort).atualizar(itemEntity);

        assertEquals("Novo Nome", itemEntity.getNome());
        assertEquals("Nova descrição", itemEntity.getDescricao());
        assertEquals(BigDecimal.valueOf(50.0), itemEntity.getPreco());
        assertTrue(itemEntity.getDisponivelLocal());
        assertEquals("/novo/caminho/foto.jpg", itemEntity.getFotoPath());
    }

    @Test
    void atualizar_deveLancarExcecaoQuandoItemNaoEncontrado() {
        String usuario = "usuario1";
        Long idItem = 1L;
        ItemCardapioDomain itemAtualizado = new ItemCardapioDomain();

        when(buscarItensCardapioOutputPort.buscarEntityPorUsuarioEIdItemCardapio(usuario, idItem))
                .thenReturn(Optional.empty());

        ItemCardapioNaoEncontradoException exception = assertThrows(ItemCardapioNaoEncontradoException.class, () ->
                atualizarItemCardapioUseCase.atualizar(usuario, idItem, itemAtualizado)
        );

        assertTrue(exception.getMessage().contains("Cardapio não encontrado"));
        assertTrue(exception.getMessage().contains("usuario1"));
        assertTrue(exception.getMessage().contains("1"));


        verify(itemCardapioValidatorHandler).validarCamposObrigatoriosAtualizarItemCardapio(itemAtualizado);
        verify(buscarItensCardapioOutputPort).buscarEntityPorUsuarioEIdItemCardapio(usuario, idItem);
        verifyNoInteractions(atualizarItemCardapioOutputPort);
    }

    @Test
    void atualizar_naoAlteraCamposNulos() {
        String usuario = "usuario1";
        Long idItem = 1L;

        ItemCardapioDomain itemAtualizado = new ItemCardapioDomain();

        ItemCardapioEntity itemEntity = new ItemCardapioEntity();
        itemEntity.setNome("Nome Existente");
        itemEntity.setDescricao("Descrição Existente");
        itemEntity.setPreco(BigDecimal.valueOf(20));
        itemEntity.setDisponivelLocal(false);
        itemEntity.setFotoPath("/caminho/existente.jpg");

        when(buscarItensCardapioOutputPort.buscarEntityPorUsuarioEIdItemCardapio(usuario, idItem))
                .thenReturn(Optional.of(itemEntity));

        atualizarItemCardapioUseCase.atualizar(usuario, idItem, itemAtualizado);

        verify(itemCardapioValidatorHandler).validarCamposObrigatoriosAtualizarItemCardapio(itemAtualizado);
        verify(atualizarItemCardapioOutputPort).atualizar(itemEntity);

        assertEquals("Nome Existente", itemEntity.getNome());
        assertEquals("Descrição Existente", itemEntity.getDescricao());
        assertEquals(BigDecimal.valueOf(20), itemEntity.getPreco());
        assertFalse(itemEntity.getDisponivelLocal());
        assertEquals("/caminho/existente.jpg", itemEntity.getFotoPath());
    }
}
