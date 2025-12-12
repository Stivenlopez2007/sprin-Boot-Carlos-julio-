package com.sena.crud_basic.service;

import com.sena.crud_basic.dto.request.ReviewCreateDTO;
import com.sena.crud_basic.dto.response.ReviewResponseDTO;

import java.util.List;

public interface ReviewService extends GenericService<ReviewCreateDTO, ReviewResponseDTO, Long> {
    
    List<ReviewResponseDTO> findByProductId(Long productId);
    
    List<ReviewResponseDTO> findByCustomerId(Long customerId);
}
