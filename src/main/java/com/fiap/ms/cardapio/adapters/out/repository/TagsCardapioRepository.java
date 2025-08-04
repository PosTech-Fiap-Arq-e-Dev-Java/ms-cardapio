package com.fiap.ms.cardapio.adapters.out.repository;

import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsCardapioRepository extends JpaRepository<TagsCardapioEntity, String> {

}
