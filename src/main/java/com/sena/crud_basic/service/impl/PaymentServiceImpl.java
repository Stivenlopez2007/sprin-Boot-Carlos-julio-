package com.sena.crud_basic.service.impl;

import com.sena.crud_basic.dto.request.PaymentCreateDTO;
import com.sena.crud_basic.dto.response.PaymentResponseDTO;
import com.sena.crud_basic.model.Payment;
import com.sena.crud_basic.model.Order;
import com.sena.crud_basic.repository.PaymentRepository;
import com.sena.crud_basic.repository.OrderRepository;
import com.sena.crud_basic.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaymentServiceImpl extends GenericServiceImpl<Payment, PaymentCreateDTO, PaymentResponseDTO, Long> 
        implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    @Override
    public List<PaymentResponseDTO> findByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentResponseDTO findByTransactionId(String transactionId) {
        // PaymentRepository no tiene este método, se debe agregar
        throw new RuntimeException("Método findByTransactionId no implementado en PaymentRepository");
    }

    @Override
    protected Payment mapToEntity(PaymentCreateDTO dto) {
        Order order = orderRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + dto.getOrderId()));

        return Payment.builder()
                .order(order)
                .paymentMethod(dto.getPaymentMethod())
                .amount(dto.getAmount())
                .paymentDate(dto.getPaymentDate() != null ? dto.getPaymentDate().toLocalDate() : null)
                .status(dto.getStatus())
                .build();
    }

    @Override
    protected void updateEntity(Payment payment, PaymentCreateDTO dto) {
        payment.setPaymentMethod(dto.getPaymentMethod());
        payment.setAmount(dto.getAmount());
        payment.setPaymentDate(dto.getPaymentDate().toLocalDate());
        payment.setStatus(dto.getStatus());
    }

    @Override
    protected PaymentResponseDTO mapToResponse(Payment payment) {
        return PaymentResponseDTO.builder()
                .id(payment.getId())
                .orderId(payment.getOrder().getId())
                .orderNumber(payment.getOrder().getOrderNumber())
                .paymentMethod(payment.getPaymentMethod())
                .amount(payment.getAmount())
                .paymentDate(payment.getPaymentDate())
                .status(payment.getStatus())
                .createdAt(payment.getCreatedAt())
                .updatedAt(payment.getUpdatedAt())
                .build();
    }

    @Override
    protected JpaRepository<Payment, Long> getRepository() {
        return paymentRepository;
    }

    @Override
    protected String getEntityName() {
        return "Pago";
    }
}
