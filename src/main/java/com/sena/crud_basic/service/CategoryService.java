package com.sena.crud_basic.service;

import com.sena.crud_basic.dto.request.CategoryCreateDTO;
import com.sena.crud_basic.dto.response.CategoryResponseDTO;

public interface CategoryService extends GenericService<CategoryCreateDTO, CategoryResponseDTO, Long> {
    
    CategoryResponseDTO findBySlug(String slug);
    
    boolean existsBySlug(String slug);
}
