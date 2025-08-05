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
    @Mapping(target = "tags", ignore = true)
    ItemCardapioDomain toDomain(ItemCardapioEntity entity);

    @Mapping(target = "idItemCardapio", ignore = true)
    @Mapping(target = "usuario", source = "usuario")
    @Mapping(target = "codigoTags", source = "codigoTags", qualifiedByName = "stringListToIntegerList")
    @Mapping(target = "tags", ignore = true)
    ItemCardapioDomain toDomain(NovoItemCardapioDto dto);

    @Mapping(target = "idItemCardapio", source = "idItemCardapio")
    @Mapping(target = "usuario", source = "usuario")
    ItemCardapioDto toDto(ItemCardapioDomain domain);

    @Mapping(target = "idItemCardapio", ignore = true)
    @Mapping(target = "usuario", source = "usuario")
    @Mapping(target = "codigoTags", ignore = true)
    ItemCardapioEntity toEntity(ItemCardapioDomain domain);

    @Mapping(target = "idItemCardapio", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "codigoTags", ignore = true)
    @Mapping(target = "tags", ignore = true)
    ItemCardapioDomain toDomain(AtualizarItemCardapioRequestDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "idItemCardapio", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "codigoTags", ignore = true)
    void updateEntityFromDto(AtualizarItemCardapioRequestDto dto, @MappingTarget ItemCardapioEntity entity);

    @AfterMapping
    default void afterToDomain(ItemCardapioEntity entity, @MappingTarget ItemCardapioDomain domain) {
        if (entity.getCodigoTags() != null) {
            List<Integer> codigos = entity.getCodigoTags()
                    .stream()
                    .map(itemTag -> itemTag.getCodigoTag().getCodigo())
                    .collect(Collectors.toList());
            domain.setCodigoTags(codigos);
        }
    }

    @Named("stringListToIntegerList")
    default List<Integer> stringListToIntegerList(List<String> codigoTags) {
        if (codigoTags == null) {
            return null;
        }
        return codigoTags.stream()
                .filter(s -> s != null && !s.isBlank())
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    @Named("integerListToStringList")
    default List<String> integerListToStringList(List<Integer> codigoTags) {
        if (codigoTags == null) {
            return null;
        }
        return codigoTags.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}









