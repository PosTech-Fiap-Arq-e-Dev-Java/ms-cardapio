package com.fiap.ms.cardapio.adapters.out.config;

import com.fiap.ms.cardapio.adapters.out.repository.TagsCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.enums.TagsCardapioEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Configuration
public class TagsCardapioDataLoaderConfig {

    @Bean
    public CommandLineRunner loadTagsCardapio(TagsCardapioRepository repository) {
        return args -> {
            List<TagsCardapioEntity> toSave = new ArrayList<>();

            TagsCardapioEnum[] sortedTags = TagsCardapioEnum.values();
            Arrays.sort(sortedTags, Comparator.comparingInt(TagsCardapioEnum::getCodigo));

            for (TagsCardapioEnum tag : sortedTags) {
                Integer codigoInt = tag.getCodigo();  // agora é Integer
                if (!repository.existsById(codigoInt)) {
                    TagsCardapioEntity entity = new TagsCardapioEntity();
                    entity.setCodigo(codigoInt);
                    entity.setNome(tag.getDescricao());
                    toSave.add(entity);
                }
            }

            if (!toSave.isEmpty()) {
                repository.saveAll(toSave);
                System.out.println("Tags do cardápio inseridas: " + toSave.size());
            }
        };
    }
}

