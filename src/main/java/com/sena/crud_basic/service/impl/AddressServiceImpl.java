package com.sena.crud_basic.service.impl;

import com.sena.crud_basic.dto.request.AddressCreateDTO;
import com.sena.crud_basic.dto.response.AddressResponseDTO;
import com.sena.crud_basic.model.Address;
import com.sena.crud_basic.repository.AddressRepository;
import com.sena.crud_basic.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AddressServiceImpl extends GenericServiceImpl<Address, AddressCreateDTO, AddressResponseDTO, Long> 
        implements AddressService {

    private final AddressRepository addressRepository;
    @Override
    public List<AddressResponseDTO> findByCustomerId(Long customerId) {
        return addressRepository.findByCustomerId(customerId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    protected Address mapToEntity(AddressCreateDTO dto) {
        // AddressCreateDTO no tiene customerId, se debe agregar o pasar por parámetro
        // Por ahora lanzamos excepción para que se implemente correctamente
        throw new RuntimeException("AddressCreateDTO necesita customerId - implementar en controller");
    }

    @Override
    protected void updateEntity(Address address, AddressCreateDTO dto) {
        address.setAddressLine1(dto.getStreet());
        address.setAddressLine2(dto.getStreetAddress());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setPostalCode(dto.getPostalCode());
        address.setCountry(dto.getCountry());
        address.setAddressType(dto.getAddressType());
    }

    @Override
    protected AddressResponseDTO mapToResponse(Address address) {
        return AddressResponseDTO.builder()
                .id(address.getId())
                .addressType(address.getAddressType())
                .street(address.getAddressLine1())
                .streetAddress(address.getAddressLine2())
                .city(address.getCity())
                .state(address.getState())
                .postalCode(address.getPostalCode())
                .country(address.getCountry())
                .createdAt(address.getCreatedAt())
                .updatedAt(address.getUpdatedAt())
                .build();
    }

    @Override
    protected JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }

    @Override
    protected String getEntityName() {
        return "Dirección";
    }
}
