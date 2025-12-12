package com.sena.crud_basic.service;

import com.sena.crud_basic.dto.request.CustomerCreateDTO;
import com.sena.crud_basic.dto.request.CustomerUpdateDTO;
import com.sena.crud_basic.dto.response.CustomerResponseDTO;

import java.util.List;

/**
 * Servicio para la gestión de clientes.
 * Extiende GenericService y agrega métodos específicos de Customer.
 */
public interface CustomerService {

    // Métodos CRUD básicos
    List<CustomerResponseDTO> findAll();
    CustomerResponseDTO findById(Long id);
    CustomerResponseDTO create(CustomerCreateDTO dto);
    CustomerResponseDTO update(Long id, CustomerUpdateDTO dto);
    void delete(Long id);

    // Métodos específicos de Customer
    CustomerResponseDTO findByEmail(String email);
    boolean existsByEmail(String email);
    List<CustomerResponseDTO> filterByName(String name);
}
