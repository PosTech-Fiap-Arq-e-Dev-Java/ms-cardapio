package com.fiap.ms.cardapio.adapters.out.repository.mapper;

import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemTagCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.ItemCardapioDomain;
import com.fiap.ms.cardapioDomain.gen.model.ItemCardapioDto;
import com.fiap.ms.cardapioDomain.gen.model.TagsCardapioDto;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ItemCardapioEntityMapper {

    @Mapping(target = "codigoTags", ignore = true)
    @Mapping(target = "tags", ignore = true)
    ItemCardapioDomain toDomain(ItemCardapioEntity entity);

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

    @Mapping(target = "codigoTags", ignore = true)
    ItemCardapioEntity toEntity(ItemCardapioDomain domain);

    @Mapping(target = "tags", expression = "java(mapTags(entity.getCodigoTags()))")
    ItemCardapioDto toDto(ItemCardapioEntity entity);

    default List<TagsCardapioDto> mapTags(List<ItemTagCardapioEntity> itemTagEntities) {
        if (itemTagEntities == null) {
            return List.of();
        }
        return itemTagEntities.stream()
                .map(this::mapTag)
                .collect(Collectors.toList());
    }

    default TagsCardapioDto mapTag(ItemTagCardapioEntity itemTagEntity) {
        TagsCardapioDto dto = new TagsCardapioDto();
        dto.setCodigoTags(String.valueOf(itemTagEntity.getCodigoTag().getCodigo()));
        dto.setNome(itemTagEntity.getCodigoTag().getNome());
        return dto;
    }
}





