package com.fiap.ms.cardapio.adapters.in.controller;

import com.fiap.ms.cardapio.adapters.in.controller.mapper.TagsCardapioDtoMapper;
import com.fiap.ms.cardapio.adapters.in.controller.mapper.ItemCardapioDtoMapper;
import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.ports.in.*;
import com.fiap.ms.cardapioDomain.CardapioApi;
import com.fiap.ms.cardapioDomain.gen.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/v1")
public class CardapioController implements CardapioApi {

    private final InserirItemCardapioInputPort inserirItemCardapioInputPort;
    private final BuscarItensCardapioInputPort buscarItemCardapioInputPort;
    private final AtualizarItemCardapioInputPort atualizarItemCardapioInputPort;
    private final DeletarItemCardapioInputPort deletarItemCardapioInputPort;
    private final ListarTagsCardapioInputPort listarTagsCardapioInputPort;
    private final InserirTagItemCardapioInputPort inserirTagItemCardapioInputPort;
    private final ItemCardapioDtoMapper itemCardapioDtoMapper;
    private final TagsCardapioDtoMapper tagsCardapioDtoMapper;

    public CardapioController(
            InserirItemCardapioInputPort inserirItemCardapioInputPort,
            BuscarItensCardapioInputPort buscarItemCardapioInputPort,
            AtualizarItemCardapioInputPort atualizarItemCardapioInputPort,
            DeletarItemCardapioInputPort deletarItemCardapioInputPort,
            ListarTagsCardapioInputPort listarTagsCardapioInputPort,
            InserirTagItemCardapioInputPort inserirTagItemCardapioInputPort,
            ItemCardapioDtoMapper itemCardapioDtoMapper,
            TagsCardapioDtoMapper tagsCardapioDtoMapper
    ) {
        this.inserirItemCardapioInputPort = inserirItemCardapioInputPort;
        this.buscarItemCardapioInputPort = buscarItemCardapioInputPort;
        this.atualizarItemCardapioInputPort = atualizarItemCardapioInputPort;
        this.deletarItemCardapioInputPort = deletarItemCardapioInputPort;
        this.listarTagsCardapioInputPort = listarTagsCardapioInputPort;
        this.inserirTagItemCardapioInputPort = inserirTagItemCardapioInputPort;
        this.itemCardapioDtoMapper = itemCardapioDtoMapper;
        this.tagsCardapioDtoMapper = tagsCardapioDtoMapper;
    }

    @Override
    public ResponseEntity<Void> _itensPost(NovoItemCardapioDto novoItemCardapioDto) {
        ItemCardapioDomain domain = itemCardapioDtoMapper.toDomain(novoItemCardapioDto);
        inserirItemCardapioInputPort.inserir(domain);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> _itensUsuarioDelete(String usuario, Integer idItemCardapio, String codigoTags) {
        executarDelete(usuario, idItemCardapio, codigoTags);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<ItemCardapioDto>> _itensUsuarioGet(String usuario, Integer idItemCardapio) {
        List<ItemCardapioDomain> domains = Optional.ofNullable(idItemCardapio)
                .map(id -> buscarItemCardapioInputPort.buscarPorUsuarioEIdItemCardapio(usuario, id.longValue()))
                .map(List::of)
                .orElseGet(() -> buscarItemCardapioInputPort.buscarPorUsuario(usuario));

        if (domains == null || domains.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<ItemCardapioDto> dtos = domains.stream()
                .map(domain -> {
                    ItemCardapioDto dto = itemCardapioDtoMapper.toDto(domain);
                    dto.setTags(buscarTagsCompletas(domain.getCodigoTags()));
                    return dto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }


    @Override
    public ResponseEntity<AtualizarItemCardapioRequestDto> _itensUsuarioPut(String usuario, Integer idItemCardapio, AtualizarItemCardapioRequestDto atualizarItemCardapioRequestDto) {
        ItemCardapioDomain domain = itemCardapioDtoMapper.toDomain(atualizarItemCardapioRequestDto);
        domain.setUsuario(usuario);
        atualizarItemCardapioInputPort.atualizar(usuario, idItemCardapio.longValue(), domain);
        return ResponseEntity.noContent().build();
    }


    @Override
    public ResponseEntity<List<TagsCardapioDto>> _itensUsuarioTagsPost(String usuario, Integer idItemCardapio, ItensUsuarioTagsPostRequestDto itensUsuarioTagsPostRequestDto) {
        String codigoTag = itensUsuarioTagsPostRequestDto.getCodigoTags();

        inserirTagItemCardapioInputPort.inserirTag(usuario, idItemCardapio.longValue(), codigoTag);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<List<TagsCardapioDto>> _tagsGet() {
        List<TagsCardapioDomain> tags = listarTagsCardapioInputPort.listar();
        List<TagsCardapioDto> dtos = tagsCardapioDtoMapper.toDtoList(tags);
        return ResponseEntity.ok(dtos);
    }

    private void executarDelete(String usuario, Integer idItemCardapio, String codigoTags) {
        if (codigoTags == null || codigoTags.isBlank()) {
            deletarItemCardapioInputPort.deletarPorUsuarioEIdItemCardapio(usuario, idItemCardapio.longValue());
        } else {
            Integer codigoTagInt = Integer.valueOf(codigoTags);
            deletarItemCardapioInputPort.deletarTagPorUsuarioEIdItemCardapio(usuario, idItemCardapio.longValue(), codigoTagInt);
        }
    }

    private List<TagsCardapioDto> buscarTagsCompletas(List<Integer> codigoTags) {
        return codigoTags.stream()
                .map(codigo -> listarTagsCardapioInputPort.buscarPorCodigo(codigo)
                        .map(tagsCardapioDtoMapper::toDto)
                        .orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}


