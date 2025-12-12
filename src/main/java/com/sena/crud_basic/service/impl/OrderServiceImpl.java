package com.sena.crud_basic.service.impl;

import com.sena.crud_basic.dto.request.OrderCreateDTO;
import com.sena.crud_basic.dto.request.OrderUpdateDTO;
import com.sena.crud_basic.dto.response.OrderResponseDTO;
import com.sena.crud_basic.model.Order;
import com.sena.crud_basic.model.Customer;
import com.sena.crud_basic.repository.OrderRepository;
import com.sena.crud_basic.repository.CustomerRepository;
import com.sena.crud_basic.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl extends GenericServiceImpl<Order, OrderCreateDTO, OrderResponseDTO, Long> 
        implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public OrderResponseDTO update(Long id, OrderUpdateDTO dto) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));

        updateEntity(order, dto);
        Order updated = orderRepository.save(order);
        return mapToResponse(updated);
    }

    @Override
    public OrderResponseDTO findByOrderNumber(String orderNumber) {
        Order order = orderRepository.findByOrderNumber(orderNumber)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con número: " + orderNumber));
        return mapToResponse(order);
    }

    @Override
    public List<OrderResponseDTO> findByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    protected Order mapToEntity(OrderCreateDTO dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + dto.getCustomerId()));

        // Calcular totales basados en los items (esto debería hacerse con los productos)
        BigDecimal subtotal = BigDecimal.ZERO;
        BigDecimal tax = BigDecimal.ZERO;
        BigDecimal shippingCost = BigDecimal.ZERO;
        BigDecimal total = subtotal.add(tax).add(shippingCost);

        return Order.builder()
                .orderNumber(generateOrderNumber())
                .customer(customer)
                .status("PENDING")
                .subtotal(subtotal)
                .tax(tax)
                .shippingCost(shippingCost)
                .total(total)
                .build();
    }

    @Override
    protected void updateEntity(Order order, OrderCreateDTO dto) {
        // Método no usado directamente
    }

    protected void updateEntity(Order order, OrderUpdateDTO dto) {
        order.setStatus(dto.getStatus());
        order.setTotal(dto.getTotalAmount());
    }

    @Override
    protected OrderResponseDTO mapToResponse(Order order) {
        return OrderResponseDTO.builder()
                .id(order.getId())
                .orderNumber(order.getOrderNumber())
                .status(order.getStatus())
                .customerName(order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName())
                .subtotal(order.getSubtotal())
                .tax(order.getTax())
                .shippingCost(order.getShippingCost())
                .total(order.getTotal())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();
    }

    @Override
    protected JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    @Override
    protected String getEntityName() {
        return "Pedido";
    }

    private String generateOrderNumber() {
        return "ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
