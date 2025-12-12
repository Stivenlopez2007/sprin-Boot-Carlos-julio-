package com.sena.crud_basic.repository;

import com.sena.crud_basic.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository para la entidad OrderProduct (tabla pivote).
 */
@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

    /**
     * Buscar todos los items de una orden
     */
    List<OrderProduct> findByOrderId(Long orderId);

    /**
     * Buscar todas las órdenes que contienen un producto
     */
    List<OrderProduct> findByProductId(Long productId);
}
