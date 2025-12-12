package com.sena.crud_basic.repository;

import com.sena.crud_basic.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository para la entidad Address.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    /**
     * Buscar todas las direcciones de un cliente
     */
    List<Address> findByCustomerId(Long customerId);

    /**
     * Buscar direcciones de un cliente por tipo
     */
    List<Address> findByCustomerIdAndAddressType(Long customerId, String addressType);
}
