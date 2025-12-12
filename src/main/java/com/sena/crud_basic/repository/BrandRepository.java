package com.sena.crud_basic.repository;

import com.sena.crud_basic.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository para la entidad Brand.
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    /**
     * Buscar marca por nombre
     */
    Optional<Brand> findByName(String name);

    /**
     * Buscar todas las marcas activas
     */
    List<Brand> findByActiveTrue();

    /**
     * Verificar si existe una marca con ese nombre
     */
    boolean existsByName(String name);
}
