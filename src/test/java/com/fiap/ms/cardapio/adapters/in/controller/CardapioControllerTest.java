package com.fiap.ms.cardapio.adapters.in.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.*;

import com.fiap.ms.cardapio.adapters.in.controller.CardapioController;
import com.fiap.ms.cardapio.adapters.in.controller.mapper.ItemCardapioDtoMapper;
import com.fiap.ms.cardapio.adapters.in.controller.mapper.TagsCardapioDtoMapper;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.exception.ItemCardapioNaoEncontradoException;
import com.fiap.ms.cardapio.application.ports.in.*;
import com.fiap.ms.cardapioDomain.gen.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;
import java.util.Optional;

class CardapioControllerTest {

    @Mock
    private InserirItemCardapioInputPort inserirItemCardapioInputPort;
    @Mock
    private BuscarItensCardapioInputPort buscarItensCardapioInputPort;
    @Mock
    private AtualizarItemCardapioInputPort atualizarItemCardapioInputPort;
    @Mock
    private DeletarItemCardapioInputPort deletarItemCardapioInputPort;
    @Mock
    private ListarTagsCardapioInputPort listarTagsCardapioInputPort;
    @Mock
    private InserirTagItemCardapioInputPort inserirTagItemCardapioInputPort;
    @Mock
    private ItemCardapioDtoMapper itemCardapioDtoMapper;
    @Mock
    private TagsCardapioDtoMapper tagsCardapioDtoMapper;

    private CardapioController controller;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        controller = new CardapioController(
                inserirItemCardapioInputPort,
                buscarItensCardapioInputPort,
                atualizarItemCardapioInputPort,
                deletarItemCardapioInputPort,
                listarTagsCardapioInputPort,
                inserirTagItemCardapioInputPort,
                itemCardapioDtoMapper,
                tagsCardapioDtoMapper
        );
    }

    @Captor
    ArgumentCaptor<ItemCardapioDomain> captor;

    @Test
    void _itensPost_deveChamarInserirERetornarCreated() {
        NovoItemCardapioDto dto = new NovoItemCardapioDto();
        ItemCardapioDomain domain = new ItemCardapioDomain();

        when(itemCardapioDtoMapper.toDomain(dto)).thenReturn(domain);

        var response = controller._itensPost(dto);

        verify(inserirItemCardapioInputPort).inserir(captor.capture());
        assertEquals(domain, captor.getValue());
        assertEquals(CREATED, response.getStatusCode());
    }

    @Test
    void _itensUsuarioGet_deveRetornarListaItensQuandoEncontrados() {
        String usuario = "usuarioParceiro";
        Integer idItem = null;

        ItemCardapioDomain domain = new ItemCardapioDomain();
        domain.setCodigoTags(List.of(1, 2));

        ItemCardapioDto dto = new ItemCardapioDto();
        TagsCardapioDto tagDto = new TagsCardapioDto();

        when(buscarItensCardapioInputPort.buscarPorUsuario(usuario)).thenReturn(List.of(domain));
        when(itemCardapioDtoMapper.toDto(domain)).thenReturn(dto);
        when(listarTagsCardapioInputPort.buscarPorCodigo(anyInt())).thenReturn(Optional.of(new TagsCardapioDomain()));
        when(tagsCardapioDtoMapper.toDto(any())).thenReturn(tagDto);

        var response = controller._itensUsuarioGet(usuario, idItem);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
        assertEquals(dto, response.getBody().get(0));
    }

    @Test
    void _itensUsuarioGet_deveLancarExcecaoQuandoItemNaoExistir() {
        String usuario = "usuarioParceiro";
        Integer idItem = 1;

        when(buscarItensCardapioInputPort.buscarPorUsuarioEIdItemCardapio(usuario, idItem.longValue()))
                .thenThrow(new ItemCardapioNaoEncontradoException(usuario, idItem.longValue()));

        ItemCardapioNaoEncontradoException exception = assertThrows(
                ItemCardapioNaoEncontradoException.class,
                () -> controller._itensUsuarioGet(usuario, idItem)
        );

        assertTrue(exception.getReason().contains("Cardapio não encontrado para usuário " + usuario + " e item " + idItem));
    }

    @Test
    void _itensUsuarioPut_deveChamarAtualizarERetornarNoContent() {
        String usuario = "useruarioParceiro";
        Integer idItem = 1;
        AtualizarItemCardapioRequestDto dto = new AtualizarItemCardapioRequestDto();
        ItemCardapioDomain domain = new ItemCardapioDomain();

        when(itemCardapioDtoMapper.toDomain(dto)).thenReturn(domain);

        var response = controller._itensUsuarioPut(usuario, idItem, dto);

        verify(atualizarItemCardapioInputPort).atualizar(usuario, idItem.longValue(), domain);
        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    void _tagsGet_deveRetornarListaDeTags() {
        TagsCardapioDomain domain = new TagsCardapioDomain();
        TagsCardapioDto dto = new TagsCardapioDto();

        when(listarTagsCardapioInputPort.listar()).thenReturn(List.of(domain));
        when(tagsCardapioDtoMapper.toDtoList(List.of(domain))).thenReturn(List.of(dto));

        var response = controller._tagsGet();

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void _itensUsuarioDelete_deveChamarDeletarItemQuandoCodigoTagsNullOuBlank() {
        String usuario = "usuarioParceiro";
        Integer idItemCardapio = 1;
        String codigoTags = null;

        var response = controller._itensUsuarioDelete(usuario, idItemCardapio, codigoTags);

        verify(deletarItemCardapioInputPort).deletarPorUsuarioEIdItemCardapio(usuario, idItemCardapio.longValue());
        assertEquals(NO_CONTENT, response.getStatusCode());

        codigoTags = " ";
        response = controller._itensUsuarioDelete(usuario, idItemCardapio, codigoTags);

        verify(deletarItemCardapioInputPort, times(2)).deletarPorUsuarioEIdItemCardapio(usuario, idItemCardapio.longValue());
        assertEquals(NO_CONTENT, response.getStatusCode());
    }

    @Test
    void _itensUsuarioDelete_deveChamarDeletarTagQuandoCodigoTagsInformado() {
        String usuario = "usuarioParceiro";
        Integer idItemCardapio = 1;
        String codigoTags = "15";

        var response = controller._itensUsuarioDelete(usuario, idItemCardapio, codigoTags);

        verify(deletarItemCardapioInputPort).deletarTagPorUsuarioEIdItemCardapio(usuario, idItemCardapio.longValue(), Integer.valueOf(codigoTags));
        assertEquals(NO_CONTENT, response.getStatusCode());
    }

    @Test
    void _itensUsuarioTagsPost_deveChamarInserirTagERetornarCreated() {
        String usuario = "usuarioParceiro";
        Integer idItemCardapio = 1;
        ItensUsuarioTagsPostRequestDto requestDto = new ItensUsuarioTagsPostRequestDto();
        requestDto.setCodigoTags("10");

        var response = controller._itensUsuarioTagsPost(usuario, idItemCardapio, requestDto);

        verify(inserirTagItemCardapioInputPort).inserirTag(usuario, idItemCardapio.longValue(), "10");
        assertEquals(CREATED, response.getStatusCode());
    }

}

