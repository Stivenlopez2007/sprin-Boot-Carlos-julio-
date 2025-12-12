package com.sena.crud_basic.repository;

import com.sena.crud_basic.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Repository para la entidad Coupon.
 */
@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

    /**
     * Buscar cupón por código
     */
    Optional<Coupon> findByCode(String code);

    /**
     * Buscar cupones activos
     */
    List<Coupon> findByIsActiveTrue();

    /**
     * Buscar cupones activos y vigentes
     */
    List<Coupon> findByIsActiveTrueAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            LocalDate currentDate1, LocalDate currentDate2);

    /**
     * Verificar si existe un cupón con ese código
     */
    boolean existsByCode(String code);
}
