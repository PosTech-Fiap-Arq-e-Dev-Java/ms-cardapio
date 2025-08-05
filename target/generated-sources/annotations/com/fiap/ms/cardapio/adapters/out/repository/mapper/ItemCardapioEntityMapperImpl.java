package com.fiap.ms.cardapio.adapters.out.repository.mapper;

import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapioDomain.gen.model.ItemCardapioDto;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-05T11:02:20-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.15 (Amazon.com Inc.)"
)
@Component
public class ItemCardapioEntityMapperImpl implements ItemCardapioEntityMapper {

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
    public ItemCardapioEntity toEntity(ItemCardapioDomain domain) {
        if ( domain == null ) {
            return null;
        }

        ItemCardapioEntity itemCardapioEntity = new ItemCardapioEntity();

        itemCardapioEntity.setIdItemCardapio( domain.getIdItemCardapio() );
        itemCardapioEntity.setNome( domain.getNome() );
        itemCardapioEntity.setDescricao( domain.getDescricao() );
        if ( domain.getPreco() != null ) {
            itemCardapioEntity.setPreco( BigDecimal.valueOf( domain.getPreco() ) );
        }
        itemCardapioEntity.setDisponivelLocal( domain.getDisponivelLocal() );
        itemCardapioEntity.setFotoPath( domain.getFotoPath() );
        itemCardapioEntity.setUsuario( domain.getUsuario() );

        return itemCardapioEntity;
    }

    @Override
    public ItemCardapioDto toDto(ItemCardapioEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ItemCardapioDto itemCardapioDto = new ItemCardapioDto();

        if ( entity.getIdItemCardapio() != null ) {
            itemCardapioDto.setIdItemCardapio( entity.getIdItemCardapio().intValue() );
        }
        itemCardapioDto.setUsuario( entity.getUsuario() );
        itemCardapioDto.setNome( entity.getNome() );
        itemCardapioDto.setDescricao( entity.getDescricao() );
        if ( entity.getPreco() != null ) {
            itemCardapioDto.setPreco( entity.getPreco().floatValue() );
        }
        itemCardapioDto.setDisponivelLocal( entity.getDisponivelLocal() );
        itemCardapioDto.setFotoPath( entity.getFotoPath() );

        itemCardapioDto.setTags( mapTags(entity.getCodigoTags()) );

        return itemCardapioDto;
    }
}
