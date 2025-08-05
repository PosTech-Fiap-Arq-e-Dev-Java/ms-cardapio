package com.fiap.ms.cardapio.adapters.in.controller.mapper;

import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapioDomain.gen.model.TagsCardapioDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-05T20:22:34-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.15 (Amazon.com Inc.)"
)
@Component
public class TagsCardapioDtoMapperImpl implements TagsCardapioDtoMapper {

    @Override
    public TagsCardapioDto toDto(TagsCardapioDomain domain) {
        if ( domain == null ) {
            return null;
        }

        TagsCardapioDto tagsCardapioDto = new TagsCardapioDto();

        if ( domain.getCodigoTags() != null ) {
            tagsCardapioDto.setCodigoTags( String.valueOf( domain.getCodigoTags() ) );
        }
        tagsCardapioDto.setNome( domain.getNome() );

        return tagsCardapioDto;
    }

    @Override
    public List<TagsCardapioDto> toDtoList(List<TagsCardapioDomain> domains) {
        if ( domains == null ) {
            return null;
        }

        List<TagsCardapioDto> list = new ArrayList<TagsCardapioDto>( domains.size() );
        for ( TagsCardapioDomain tagsCardapioDomain : domains ) {
            list.add( toDto( tagsCardapioDomain ) );
        }

        return list;
    }
}
