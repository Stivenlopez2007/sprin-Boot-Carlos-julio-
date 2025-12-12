package com.sena.crud_basic.repository;

import com.sena.crud_basic.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository para la entidad Category.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     * Buscar categoría por slug
     */
    Optional<Category> findBySlug(String slug);

    /**
     * Verificar si existe una categoría con ese slug
     */
    boolean existsBySlug(String slug);

    /**
     * Buscar categoría por nombre
     */
    Optional<Category> findByName(String name);
}
