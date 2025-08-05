package com.fiap.ms.cardapio.adapters.out.repository.mapper;

import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-05T20:22:34-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.15 (Amazon.com Inc.)"
)
@Component
public class TagsCardapioEntityMapperImpl implements TagsCardapioEntityMapper {

    @Override
    public TagsCardapioDomain toDomain(TagsCardapioEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TagsCardapioDomain tagsCardapioDomain = new TagsCardapioDomain();

        tagsCardapioDomain.setCodigoTags( entity.getCodigo() );
        tagsCardapioDomain.setNome( entity.getNome() );

        return tagsCardapioDomain;
    }

    @Override
    public TagsCardapioEntity toEntity(TagsCardapioDomain domain) {
        if ( domain == null ) {
            return null;
        }

        TagsCardapioEntity tagsCardapioEntity = new TagsCardapioEntity();

        tagsCardapioEntity.setCodigo( domain.getCodigoTags() );
        tagsCardapioEntity.setNome( domain.getNome() );

        return tagsCardapioEntity;
    }
}
