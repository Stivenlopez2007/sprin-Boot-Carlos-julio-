package com.sena.crud_basic.service;

import com.sena.crud_basic.dto.request.PaymentCreateDTO;
import com.sena.crud_basic.dto.response.PaymentResponseDTO;

import java.util.List;

public interface PaymentService extends GenericService<PaymentCreateDTO, PaymentResponseDTO, Long> {
    
    List<PaymentResponseDTO> findByOrderId(Long orderId);
    
    PaymentResponseDTO findByTransactionId(String transactionId);
}
