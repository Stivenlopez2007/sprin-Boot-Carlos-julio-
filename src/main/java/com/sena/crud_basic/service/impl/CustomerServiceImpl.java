package com.sena.crud_basic.service.impl;

import com.sena.crud_basic.dto.request.CustomerCreateDTO;
import com.sena.crud_basic.dto.request.CustomerUpdateDTO;
import com.sena.crud_basic.dto.response.CustomerResponseDTO;
import com.sena.crud_basic.model.Customer;
import com.sena.crud_basic.repository.CustomerRepository;
import com.sena.crud_basic.service.CustomerService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    // ==================== Métodos CRUD Básicos ====================

    @Override
    @Transactional(readOnly = true)
    public List<CustomerResponseDTO> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerResponseDTO findById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
        return mapToResponse(customer);
    }

    @Override
    public CustomerResponseDTO create(CustomerCreateDTO dto) {
        // Validar que el email no exista
        if (customerRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Ya existe un cliente con el email: " + dto.getEmail());
        }

        Customer customer = mapToEntityFromCreate(dto);
        // TODO: Hashear password con BCryptPasswordEncoder
        // customer.setPassword(passwordEncoder.encode(dto.getPassword()));
        
        Customer saved = customerRepository.save(customer);
        return mapToResponse(saved);
    }

    @Override
    public CustomerResponseDTO update(Long id, CustomerUpdateDTO dto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));

        // Validar que el email no esté en uso por otro cliente
        customerRepository.findByEmail(dto.getEmail())
                .ifPresent(existing -> {
                    if (!existing.getId().equals(id)) {
                        throw new RuntimeException("El email ya está en uso por otro cliente");
                    }
                });

        updateEntityFromUpdate(customer, dto);
        Customer updated = customerRepository.save(customer);
        return mapToResponse(updated);
    }

    @Override
    public void delete(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado con ID: " + id);
        }
        customerRepository.deleteById(id);
    }

    // ==================== Métodos Específicos ====================

    @Override
    @Transactional(readOnly = true)
    public CustomerResponseDTO findByEmail(String email) {
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con email: " + email));
        return mapToResponse(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerResponseDTO> filterByName(String name) {
        // Buscar por firstName o lastName que contengan el texto
        return customerRepository.findAll()
                .stream()
                .filter(c -> c.getFirstName().toLowerCase().contains(name.toLowerCase()) ||
                           c.getLastName().toLowerCase().contains(name.toLowerCase()))
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==================== Métodos de Mapeo ====================

    private Customer mapToEntityFromCreate(CustomerCreateDTO dto) {
        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setPassword(dto.getPassword()); // TODO: Hashear
        customer.setDateOfBirth(dto.getDateOfBirth());
        return customer;
    }

    private void updateEntityFromUpdate(Customer customer, CustomerUpdateDTO dto) {
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setDateOfBirth(dto.getDateOfBirth());
        // NO actualizamos password aquí
    }

    private CustomerResponseDTO mapToResponse(Customer customer) {
        return CustomerResponseDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .dateOfBirth(customer.getDateOfBirth())
                .createdAt(customer.getCreatedAt())
                .updatedAt(customer.getUpdatedAt())
                .build();
    }
}
