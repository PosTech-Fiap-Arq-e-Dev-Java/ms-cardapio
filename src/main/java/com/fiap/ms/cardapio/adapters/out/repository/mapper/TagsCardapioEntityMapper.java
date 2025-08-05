package com.fiap.ms.cardapio.adapters.out.repository.mapper;

import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TagsCardapioEntityMapper {

    @Mapping(source = "codigo", target = "codigoTags")
    TagsCardapioDomain toDomain(TagsCardapioEntity entity);

    @Mapping(source = "codigoTags", target = "codigo")
    TagsCardapioEntity toEntity(TagsCardapioDomain domain);
}



