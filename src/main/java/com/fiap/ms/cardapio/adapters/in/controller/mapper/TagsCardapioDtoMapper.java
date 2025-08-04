package com.fiap.ms.cardapio.adapters.in.controller.mapper;

import com.fiap.ms.cardapio.application.core.domain.TagsCardapioDomain;
import com.fiap.ms.cardapioDomain.gen.model.TagsCardapioDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TagsCardapioDtoMapper {

    TagsCardapioDto toDto(TagsCardapioDomain domain);

    List<TagsCardapioDto> toDtoList(List<TagsCardapioDomain> domains);
}


