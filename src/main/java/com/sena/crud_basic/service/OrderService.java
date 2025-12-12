package com.sena.crud_basic.service;

import com.sena.crud_basic.dto.request.OrderCreateDTO;
import com.sena.crud_basic.dto.request.OrderUpdateDTO;
import com.sena.crud_basic.dto.response.OrderResponseDTO;

import java.util.List;

public interface OrderService extends GenericService<OrderCreateDTO, OrderResponseDTO, Long> {
    
    OrderResponseDTO update(Long id, OrderUpdateDTO dto);
    
    OrderResponseDTO findByOrderNumber(String orderNumber);
    
    List<OrderResponseDTO> findByCustomerId(Long customerId);
}
