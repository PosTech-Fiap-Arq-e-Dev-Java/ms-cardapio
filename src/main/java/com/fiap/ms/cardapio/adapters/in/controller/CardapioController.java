package com.fiap.ms.cardapio.adapters.in.controller;

import com.fiap.ms.cardapio.adapters.in.controller.mapper.TagsCardapioDtoMapper;
import com.fiap.ms.cardapio.adapters.in.controller.mapper.ItemCardapioDtoMapper;
import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapio.application.ports.in.*;
import com.fiap.ms.cardapioDomain.CardapioApi;
import com.fiap.ms.cardapioDomain.gen.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CardapioController implements CardapioApi {

    private final InserirItemCardapioInputPort inserirItemCardapioInputPort;
    private final BuscarItensCardapioInputPort buscarItemCardapioInputPort;
    private final AtualizarItemCardapioInputPort atualizarItemCardapioInputPort;
    private final DeletarItemCardapioInputPort deletarItemCardapioInputPort;
    private final ListarTagsCardapioInputPort listarTagsCardapioInputPort;
    private final InserirTagItemCardapioInputPort inserirTagItemCardapioInputPort;
    private final ItemCardapioDtoMapper itemCardapioDtoMapper;
    private final TagsCardapioDtoMapper tagsCardapioDtoMapper;

    @Override
    public ResponseEntity<List<ItemCardapioDto>> _msCardapioV1ItensUsuarioGet(String usuario, Integer idItemCardapio) {
        List<ItemCardapioDomain> domains = Optional.ofNullable(idItemCardapio)
                .map(id -> buscarItemCardapioInputPort.buscarPorUsuarioEId(usuario, id.longValue()))
                .map(List::of)
                .orElseGet(() -> buscarItemCardapioInputPort.buscarPorUsuario(usuario));

        if (domains == null || domains.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<ItemCardapioDto> dtos = domains.stream()
                .map(itemCardapioDtoMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<Void> _msCardapioV1ItensUsuarioPut(String usuario, Integer idItemCardapio, AtualizarItemCardapioRequestDto atualizarDto) {
        ItemCardapioDomain domain = itemCardapioDtoMapper.toDomain(atualizarDto);
        domain.setUsuario(usuario);
        atualizarItemCardapioInputPort.atualizar(usuario, idItemCardapio.longValue(), domain);
        return ResponseEntity.noContent().build();
    }


    @Override
    public ResponseEntity<Void> _msCardapioV1ItensUsuarioTagsPost(String usuario, Integer idItemCardapio, MsCardapioV1ItensUsuarioTagsPostRequestDto tagRequestDto) {
        String codigoTag = tagRequestDto.getCodigoTags();

        inserirTagItemCardapioInputPort.inserirTag(usuario, idItemCardapio.longValue(), codigoTag);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<List<TagsCardapioDto>> _msCardapioV1TagsGet() {
        List<TagsCardapioDomain> tags = listarTagsCardapioInputPort.listar();
        List<TagsCardapioDto> dtos = tagsCardapioDtoMapper.toDtoList(tags);
        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<Void> _msCardapioV1ItensUsuarioDelete(String usuario, Integer idItemCardapio) {
        deletarItemCardapioInputPort.deletarPorUsuarioEId(usuario, idItemCardapio.longValue());
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> _msCardapioV1ItensUsuarioDelete(String usuario, Integer idItemCardapio, String codigoTag) {
        deletarItemCardapioInputPort.deletarTagPorUsuarioEId(usuario, idItemCardapio.longValue(), codigoTag);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> _msCardapioV1ItensPost(NovoItemCardapioDto novoItemCardapioDto) {
        ItemCardapioDomain domain = itemCardapioDtoMapper.toDomain(novoItemCardapioDto);
        inserirItemCardapioInputPort.inserir(domain);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

