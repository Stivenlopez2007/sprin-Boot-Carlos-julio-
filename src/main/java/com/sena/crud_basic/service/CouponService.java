package com.sena.crud_basic.service;

import com.sena.crud_basic.dto.request.CouponCreateDTO;
import com.sena.crud_basic.dto.response.CouponResponseDTO;

public interface CouponService extends GenericService<CouponCreateDTO, CouponResponseDTO, Long> {
    
    CouponResponseDTO findByCode(String code);
    
    boolean existsByCode(String code);
}
