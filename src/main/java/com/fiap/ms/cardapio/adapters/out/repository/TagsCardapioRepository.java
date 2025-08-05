package com.fiap.ms.cardapio.adapters.out.repository;

import com.fiap.ms.cardapio.adapters.out.repository.entity.TagsCardapioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagsCardapioRepository extends JpaRepository<TagsCardapioEntity, Integer> {

    List<TagsCardapioEntity> findAllByOrderByCodigoAsc();

    Optional<TagsCardapioEntity> findByCodigo(Integer codigo);

}

