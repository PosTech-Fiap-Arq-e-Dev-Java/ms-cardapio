package com.fiap.ms.cardapio.adapters.out.repository;

import com.fiap.ms.cardapio.adapters.out.repository.entity.ItemCardapioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemCardapioRepository extends JpaRepository<ItemCardapioEntity, Long> {

    Optional<ItemCardapioEntity> findByUsuarioAndId(String usuario, Long id);

    List<ItemCardapioEntity> findByUsuario(String usuario);

}



