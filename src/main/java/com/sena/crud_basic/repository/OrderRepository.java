package com.sena.crud_basic.repository;

import com.sena.crud_basic.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository para la entidad Order.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * Buscar orden por número de orden
     */
    Optional<Order> findByOrderNumber(String orderNumber);

    /**
     * Buscar todas las órdenes de un cliente
     */
    List<Order> findByCustomerId(Long customerId);

    /**
     * Buscar órdenes por estado
     */
    List<Order> findByStatus(String status);

    /**
     * Buscar órdenes de un cliente por estado
     */
    List<Order> findByCustomerIdAndStatus(Long customerId, String status);

    /**
     * Verificar si existe una orden con ese número
     */
    boolean existsByOrderNumber(String orderNumber);
}
