package com.fiap.ms.cardapio.adapters.in.controller.mapper;

import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapioDomain.gen.model.AtualizarItemCardapioRequestDto;
import com.fiap.ms.cardapioDomain.gen.model.ItemCardapioDto;
import com.fiap.ms.cardapioDomain.gen.model.NovoItemCardapioDto;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ItemCardapioDtoMapper {

    @Mapping(target = "idItemCardapio", source = "idItemCardapio")
    @Mapping(target = "usuario", source = "usuario")
    @Mapping(target = "codigoTags", ignore = true)
    ItemCardapioDomain toDomain(ItemCardapioEntity entity);

    @Mapping(target = "idItemCardapio", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "codigoTags", ignore = true)
    ItemCardapioDomain toDomain(AtualizarItemCardapioRequestDto dto);

    @Mapping(target = "idItemCardapio", ignore = true)
    @Mapping(target = "usuario", source = "usuario")
    @Mapping(target = "codigoTags", ignore = true)
    ItemCardapioDomain toDomain(NovoItemCardapioDto dto);

    @Mapping(target = "idItemCardapio", source = "idItemCardapio")
    @Mapping(target = "usuario", source = "usuario")
    @Mapping(target = "codigoTags", source = "codigoTags")
    ItemCardapioDto toDto(ItemCardapioDomain domain);

    @Mapping(target = "idItemCardapio", ignore = true)
    @Mapping(target = "usuario", source = "usuario")
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






