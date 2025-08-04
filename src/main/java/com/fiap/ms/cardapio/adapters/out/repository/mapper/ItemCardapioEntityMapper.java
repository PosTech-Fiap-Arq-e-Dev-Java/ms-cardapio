package com.fiap.ms.cardapio.adapters.out.repository.mapper;

import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ItemCardapioEntityMapper {

    ItemCardapioEntityMapper INSTANCE = Mappers.getMapper(ItemCardapioEntityMapper.class);

    @Mapping(target = "codigoTags", ignore = true)
    ItemCardapioDomain toDomain(ItemCardapioEntity entity);

    @Mapping(target = "codigoTags", ignore = true)
    ItemCardapioEntity toEntity(ItemCardapioDomain domain);

    @AfterMapping
    default void afterToDomain(ItemCardapioEntity entity, @MappingTarget ItemCardapioDomain domain) {
        if (entity.getCodigoTags() != null) {
            List<String> codigos = entity.getCodigoTags()
                    .stream()
                    .map(itemTag -> itemTag.getCodigoTag().getCodigo())
                    .collect(Collectors.toList());
            domain.setCodigoTags(codigos);
        }
    }
}

