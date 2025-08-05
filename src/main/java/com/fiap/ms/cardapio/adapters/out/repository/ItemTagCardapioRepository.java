package com.fiap.ms.cardapio.adapters.out.repository;

import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemTagCardapioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemTagCardapioRepository extends JpaRepository<ItemTagCardapioEntity, Long> {

    Optional<ItemTagCardapioEntity> findByItemCardapio_IdItemCardapioAndCodigoTag_CodigoAndItemCardapio_Usuario(Long itemId, Integer codigo, String usuario);

}


