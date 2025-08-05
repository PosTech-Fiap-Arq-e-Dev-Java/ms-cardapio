package com.fiap.ms.cardapio.application.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.exception.CampoObrigatorioException;
import com.fiap.ms.cardapio.application.core.domain.exception.ItemCardapioNaoEncontradoException;
import com.fiap.ms.cardapio.application.core.domain.exception.MaxTagsExcedidasException;
import com.fiap.ms.cardapio.application.core.domain.exception.TagNaoEncontradaException;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarTagsCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.InserirTagItemCardapioOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;
import java.util.Optional;

public class InserirTagItemCardapioUseCaseTest {

    @Mock
    private BuscarItensCardapioOutputPort buscarItensCardapioOutputPort;

    @Mock
    private BuscarTagsCardapioOutputPort buscarTagsCardapioOutputPort;

    @Mock
    private InserirTagItemCardapioOutputPort inserirTagItemCardapioOutputPort;

    @InjectMocks
    private InserirTagItemCardapioUseCase useCase;

    private final String usuario = "usuario1";
    private final Long idItem = 1L;
    private final String codigoTags = "10";

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void inserirTag_deveLancarCampoObrigatorioException_quandoCodigoTagsNuloOuVazio() {
        assertThrows(CampoObrigatorioException.class, () -> useCase.inserirTag(usuario, idItem, null));
        assertThrows(CampoObrigatorioException.class, () -> useCase.inserirTag(usuario, idItem, ""));
        assertThrows(CampoObrigatorioException.class, () -> useCase.inserirTag(usuario, idItem, "   "));
    }

    @Test
    void inserirTag_deveLancarItemCardapioNaoEncontradoException_quandoItemNaoEncontrado() {
        when(buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, idItem))
                .thenReturn(Optional.empty());

        ItemCardapioNaoEncontradoException ex = assertThrows(ItemCardapioNaoEncontradoException.class,
                () -> useCase.inserirTag(usuario, idItem, codigoTags));

        assertTrue(ex.getMessage().contains("Cardapio não encontrado"));
    }

    @Test
    void inserirTag_deveLancarMaxTagsExcedidasException_quandoItemPossui5OuMaisTags() {
        ItemCardapioDomain item = new ItemCardapioDomain();
        item.setCodigoTags(List.of(1, 2, 3, 4, 5, 6, 7));

        when(buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, idItem))
                .thenReturn(Optional.of(item));
        when(buscarTagsCardapioOutputPort.buscarPorCodigo(Integer.valueOf(codigoTags)))
                .thenReturn(Optional.of(new TagsCardapioDomain()));

        MaxTagsExcedidasException ex = assertThrows(MaxTagsExcedidasException.class,
                () -> useCase.inserirTag(usuario, idItem, codigoTags));

        assertNotNull(ex);
    }


    @Test
    void inserirTag_deveLancarTagNaoEncontradaException_quandoTagNaoExiste() {
        ItemCardapioDomain item = new ItemCardapioDomain();

        when(buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, idItem))
                .thenReturn(Optional.of(item));

        when(buscarTagsCardapioOutputPort.buscarPorCodigo(Integer.valueOf(codigoTags)))
                .thenReturn(Optional.empty());

        TagNaoEncontradaException ex = assertThrows(TagNaoEncontradaException.class,
                () -> useCase.inserirTag(usuario, idItem, codigoTags));

        assertTrue(ex.getMessage().contains(codigoTags));
    }

    @Test
    void inserirTag_deveChamarInserir_quandoTudoValido() {
        ItemCardapioDomain item = new ItemCardapioDomain();
        item.setCodigoTags(List.of(Integer.valueOf(codigoTags)));

        TagsCardapioDomain tagDomain = new TagsCardapioDomain();
        tagDomain.setCodigoTags(Integer.valueOf(codigoTags));

        when(buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, idItem))
                .thenReturn(Optional.of(item));
        when(buscarTagsCardapioOutputPort.buscarPorCodigo(Integer.valueOf(codigoTags)))
                .thenReturn(Optional.of(tagDomain));

        useCase.inserirTag(usuario, idItem, codigoTags);

        verify(inserirTagItemCardapioOutputPort, times(1)).inserir(usuario, idItem, tagDomain);
    }

}

