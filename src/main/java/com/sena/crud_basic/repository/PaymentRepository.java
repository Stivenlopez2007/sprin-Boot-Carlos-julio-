package com.sena.crud_basic.repository;

import com.sena.crud_basic.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository para la entidad Payment.
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    /**
     * Buscar todos los pagos de una orden
     */
    List<Payment> findByOrderId(Long orderId);

    /**
     * Buscar pagos por estado
     */
    List<Payment> findByStatus(String status);

    /**
     * Buscar pagos por método de pago
     */
    List<Payment> findByPaymentMethod(String paymentMethod);
}
