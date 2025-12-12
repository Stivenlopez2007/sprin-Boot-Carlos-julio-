package com.sena.crud_basic.service;

import com.sena.crud_basic.dto.request.AddressCreateDTO;
import com.sena.crud_basic.dto.response.AddressResponseDTO;

import java.util.List;

public interface AddressService extends GenericService<AddressCreateDTO, AddressResponseDTO, Long> {
    
    List<AddressResponseDTO> findByCustomerId(Long customerId);
}
