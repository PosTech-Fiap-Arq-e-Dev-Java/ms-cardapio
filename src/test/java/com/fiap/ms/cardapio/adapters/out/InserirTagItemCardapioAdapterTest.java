package com.fiap.ms.cardapio.adapters.out;

import com.fiap.ms.cardapio.adapters.out.repository.ItemTagCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemTagCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.mapper.ItemCardapioEntityMapper;
import com.fiap.ms.cardapio.adapters.out.repository.mapper.TagsCardapioEntityMapper;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapio.application.ports.out.BuscarItensCardapioOutputPort;
import com.fiap.ms.cardapio.application.ports.out.BuscarTagsCardapioOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

class InserirTagItemCardapioAdapterTest {

    private BuscarItensCardapioOutputPort buscarItensCardapioOutputPort;
    private BuscarTagsCardapioOutputPort buscarTagsCardapioOutputPort;
    private ItemTagCardapioRepository itemTagCardapioRepository;
    private ItemCardapioEntityMapper mapper;
    private TagsCardapioEntityMapper tagsCardapioEntityMapper;

    private InserirTagItemCardapioAdapter adapter;

    @BeforeEach
    void setUp() {
        buscarItensCardapioOutputPort = mock(BuscarItensCardapioOutputPort.class);
        buscarTagsCardapioOutputPort = mock(BuscarTagsCardapioOutputPort.class);
        itemTagCardapioRepository = mock(ItemTagCardapioRepository.class);
        mapper = mock(ItemCardapioEntityMapper.class);
        tagsCardapioEntityMapper = mock(TagsCardapioEntityMapper.class);

        adapter = new InserirTagItemCardapioAdapter(
                buscarItensCardapioOutputPort,
                buscarTagsCardapioOutputPort,
                itemTagCardapioRepository,
                mapper,
                tagsCardapioEntityMapper
        );
    }

    @Test
    void inserir_deveSalvarNovaTagQuandoItemETagExistem() {
        // Arrange
        String usuario = "usuarioTeste";
        Long idItemCardapio = 1L;

        TagsCardapioDomain tagDomain = new TagsCardapioDomain();
        tagDomain.setCodigoTags(15);

        ItemCardapioDomain itemDomain = new ItemCardapioDomain();

        ItemCardapioEntity itemEntity = new ItemCardapioEntity();
        TagsCardapioEntity tagEntity = new TagsCardapioEntity();

        when(buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, idItemCardapio))
                .thenReturn(Optional.of(itemDomain));
        when(buscarTagsCardapioOutputPort.buscarPorCodigo(tagDomain.getCodigoTags()))
                .thenReturn(Optional.of(tagDomain));
        when(mapper.toEntity(itemDomain)).thenReturn(itemEntity);
        when(tagsCardapioEntityMapper.toEntity(tagDomain)).thenReturn(tagEntity);

        adapter.inserir(usuario, idItemCardapio, tagDomain);

        verify(itemTagCardapioRepository, times(1)).save(any(ItemTagCardapioEntity.class));
    }

    @Test
    void inserir_naoDeveSalvarQuandoItemNaoExiste() {
        String usuario = "usuarioTeste";
        Long idItemCardapio = 1L;
        TagsCardapioDomain tagDomain = new TagsCardapioDomain();
        tagDomain.setCodigoTags(15);

        when(buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, idItemCardapio))
                .thenReturn(Optional.empty());

        adapter.inserir(usuario, idItemCardapio, tagDomain);

        verify(itemTagCardapioRepository, never()).save(any());
    }

    @Test
    void inserir_naoDeveSalvarQuandoTagNaoExiste() {
        String usuario = "usuarioTeste";
        Long idItemCardapio = 1L;
        TagsCardapioDomain tagDomain = new TagsCardapioDomain();
        tagDomain.setCodigoTags(15);

        ItemCardapioDomain itemDomain = new ItemCardapioDomain();

        when(buscarItensCardapioOutputPort.buscarPorUsuarioEIdItemCardapio(usuario, idItemCardapio))
                .thenReturn(Optional.of(itemDomain));
        when(buscarTagsCardapioOutputPort.buscarPorCodigo(tagDomain.getCodigoTags()))
                .thenReturn(Optional.empty());

        adapter.inserir(usuario, idItemCardapio, tagDomain);

        verify(itemTagCardapioRepository, never()).save(any());
    }
}

