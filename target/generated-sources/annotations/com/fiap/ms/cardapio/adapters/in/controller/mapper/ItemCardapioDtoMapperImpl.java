package com.fiap.ms.cardapio.adapters.in.controller.mapper;

import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapioDomain.gen.model.AtualizarItemCardapioRequestDto;
import com.fiap.ms.cardapioDomain.gen.model.ItemCardapioDto;
import com.fiap.ms.cardapioDomain.gen.model.NovoItemCardapioDto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-03T22:46:05-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.15 (Amazon.com Inc.)"
)
@Component
public class ItemCardapioDtoMapperImpl implements ItemCardapioDtoMapper {

    @Override
    public ItemCardapioDomain toDomain(ItemCardapioEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ItemCardapioDomain itemCardapioDomain = new ItemCardapioDomain();

        itemCardapioDomain.setIdItemCardapio( entity.getIdItemCardapio() );
        itemCardapioDomain.setUsuario( entity.getUsuario() );
        itemCardapioDomain.setNome( entity.getNome() );
        itemCardapioDomain.setDescricao( entity.getDescricao() );
        if ( entity.getPreco() != null ) {
            itemCardapioDomain.setPreco( entity.getPreco().doubleValue() );
        }
        itemCardapioDomain.setDisponivelLocal( entity.getDisponivelLocal() );
        itemCardapioDomain.setFotoPath( entity.getFotoPath() );

        afterToDomain( entity, itemCardapioDomain );

        return itemCardapioDomain;
    }

    @Override
    public ItemCardapioDomain toDomain(AtualizarItemCardapioRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        ItemCardapioDomain itemCardapioDomain = new ItemCardapioDomain();

        itemCardapioDomain.setNome( dto.getNome() );
        itemCardapioDomain.setDescricao( dto.getDescricao() );
        if ( dto.getPreco() != null ) {
            itemCardapioDomain.setPreco( dto.getPreco().doubleValue() );
        }
        itemCardapioDomain.setDisponivelLocal( dto.getDisponivelLocal() );
        itemCardapioDomain.setFotoPath( dto.getFotoPath() );

        return itemCardapioDomain;
    }

    @Override
    public ItemCardapioDomain toDomain(NovoItemCardapioDto dto) {
        if ( dto == null ) {
            return null;
        }

        ItemCardapioDomain itemCardapioDomain = new ItemCardapioDomain();

        itemCardapioDomain.setUsuario( dto.getUsuario() );
        itemCardapioDomain.setNome( dto.getNome() );
        itemCardapioDomain.setDescricao( dto.getDescricao() );
        if ( dto.getPreco() != null ) {
            itemCardapioDomain.setPreco( dto.getPreco().doubleValue() );
        }
        itemCardapioDomain.setDisponivelLocal( dto.getDisponivelLocal() );
        itemCardapioDomain.setFotoPath( dto.getFotoPath() );

        return itemCardapioDomain;
    }

    @Override
    public ItemCardapioDto toDto(ItemCardapioDomain domain) {
        if ( domain == null ) {
            return null;
        }

        ItemCardapioDto itemCardapioDto = new ItemCardapioDto();

        if ( domain.getIdItemCardapio() != null ) {
            itemCardapioDto.setIdItemCardapio( domain.getIdItemCardapio().intValue() );
        }
        itemCardapioDto.setUsuario( domain.getUsuario() );
        List<String> list = domain.getCodigoTags();
        if ( list != null ) {
            itemCardapioDto.setCodigoTags( new ArrayList<String>( list ) );
        }
        itemCardapioDto.setNome( domain.getNome() );
        itemCardapioDto.setDescricao( domain.getDescricao() );
        if ( domain.getPreco() != null ) {
            itemCardapioDto.setPreco( domain.getPreco().floatValue() );
        }
        itemCardapioDto.setDisponivelLocal( domain.getDisponivelLocal() );
        itemCardapioDto.setFotoPath( domain.getFotoPath() );

        return itemCardapioDto;
    }

    @Override
    public ItemCardapioEntity toEntity(ItemCardapioDomain domain) {
        if ( domain == null ) {
            return null;
        }

        ItemCardapioEntity itemCardapioEntity = new ItemCardapioEntity();

        itemCardapioEntity.setUsuario( domain.getUsuario() );
        itemCardapioEntity.setNome( domain.getNome() );
        itemCardapioEntity.setDescricao( domain.getDescricao() );
        if ( domain.getPreco() != null ) {
            itemCardapioEntity.setPreco( BigDecimal.valueOf( domain.getPreco() ) );
        }
        itemCardapioEntity.setDisponivelLocal( domain.getDisponivelLocal() );
        itemCardapioEntity.setFotoPath( domain.getFotoPath() );

        return itemCardapioEntity;
    }
}
