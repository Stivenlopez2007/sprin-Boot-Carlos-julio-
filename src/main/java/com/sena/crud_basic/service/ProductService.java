package com.sena.crud_basic.service;

import com.sena.crud_basic.dto.request.ProductCreateDTO;
import com.sena.crud_basic.dto.request.ProductUpdateDTO;
import com.sena.crud_basic.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService extends GenericService<ProductCreateDTO, ProductResponseDTO, Long> {
    
    ProductResponseDTO update(Long id, ProductUpdateDTO dto);
    
    ProductResponseDTO findBySku(String sku);
    
    List<ProductResponseDTO> findByActiveTrue();
    
    boolean existsBySku(String sku);
    
    List<ProductResponseDTO> filterByName(String name);
}
