package com.sena.crud_basic.repository;

import com.sena.crud_basic.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository para la entidad Review.
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    /**
     * Buscar todas las reseñas de un producto
     */
    List<Review> findByProductId(Long productId);

    /**
     * Buscar todas las reseñas de un cliente
     */
    List<Review> findByCustomerId(Long customerId);

    /**
     * Buscar reseñas verificadas de un producto
     */
    List<Review> findByProductIdAndIsVerifiedPurchaseTrue(Long productId);

    /**
     * Buscar reseñas por calificación
     */
    List<Review> findByRating(Integer rating);
}
