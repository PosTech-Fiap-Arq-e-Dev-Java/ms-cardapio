package com.fiap.ms.cardapio.adapters.out.config;

import com.fiap.ms.cardapio.adapters.out.repository.TagsCardapioRepository;
import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import com.fiap.ms.cardapio.application.core.domain.enums.TagsCardapioEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TagsCardapioDataLoaderConfig {

    @Bean
    public CommandLineRunner loadTagsCardapio(TagsCardapioRepository repository) {
        return args -> {
            List<TagsCardapioEntity> toSave = new ArrayList<>();
            for (TagsCardapioEnum tag : TagsCardapioEnum.values()) {
                if (!repository.existsById(String.valueOf((long) tag.getCodigo()))) {
                    TagsCardapioEntity entity = new TagsCardapioEntity();
                    entity.setCodigo(String.valueOf(tag.getCodigo()));
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

