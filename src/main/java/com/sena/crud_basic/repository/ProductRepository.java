package com.sena.crud_basic.repository;

import com.sena.crud_basic.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository para la entidad Product.
 * JpaRepository proporciona métodos CRUD automáticamente:
 * - save(Product) - Guardar o actualizar
 * - findById(Long) - Buscar por ID
 * - findAll() - Obtener todos
 * - deleteById(Long) - Eliminar por ID
 * - count() - Contar registros
 * etc.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Buscar producto por SKU (código único)
     * Método generado automáticamente por Spring Data JPA
     */
    Optional<Product> findBySku(String sku);

    /**
     * Buscar todos los productos activos
     */
    List<Product> findByActiveTrue();

    /**
     * Buscar productos por nombre (búsqueda parcial)
     * LIKE '%name%'
     */
    List<Product> findByNameContainingIgnoreCase(String name);

    /**
     * Verificar si existe un producto con ese SKU
     */
    boolean existsBySku(String sku);
}
