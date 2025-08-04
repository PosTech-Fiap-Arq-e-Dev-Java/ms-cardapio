package com.fiap.ms.cardapio.adapters.out.repository.mapper;

import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-03T22:46:05-0300",
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
}
