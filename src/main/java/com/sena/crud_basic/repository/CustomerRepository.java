package com.sena.crud_basic.repository;

import com.sena.crud_basic.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository para la entidad Customer.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Buscar cliente por email
     */
    Optional<Customer> findByEmail(String email);

    /**
     * Verificar si existe un cliente con ese email
     */
    boolean existsByEmail(String email);

    /**
     * Buscar cliente por nombre y apellido
     */
    Optional<Customer> findByFirstNameAndLastName(String firstName, String lastName);
}
