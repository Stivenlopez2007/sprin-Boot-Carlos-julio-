package com.sena.crud_basic.repository;

import com.sena.crud_basic.model.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository para la entidad CategoryProduct (tabla pivote).
 */
@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Long> {

    /**
     * Buscar todas las relaciones de una categoría
     */
    List<CategoryProduct> findByCategoryId(Long categoryId);

    /**
     * Buscar todas las categorías de un producto
     */
    List<CategoryProduct> findByProductId(Long productId);

    /**
     * Eliminar todas las relaciones de un producto
     */
    void deleteByProductId(Long productId);
}
