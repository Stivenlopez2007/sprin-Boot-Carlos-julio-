package com.sena.crud_basic.service;

import com.sena.crud_basic.dto.request.BrandCreateDTO;
import com.sena.crud_basic.dto.response.BrandResponseDTO;

import java.util.List;

public interface BrandService extends GenericService<BrandCreateDTO, BrandResponseDTO, Long> {
    
    BrandResponseDTO findByName(String name);
    
    List<BrandResponseDTO> findByActiveTrue();
    
    boolean existsByName(String name);
}
