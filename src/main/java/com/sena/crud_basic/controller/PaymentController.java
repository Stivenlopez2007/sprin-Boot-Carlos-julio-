package com.sena.crud_basic.controller;

import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crud_basic.dto.request.PaymentCreateDTO;
import com.sena.crud_basic.dto.response.PaymentResponseDTO;
import com.sena.crud_basic.dto.view.JsonViews;
import com.sena.crud_basic.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
@Tag(name = "Payments", description = "API para gestión de pagos")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<PaymentResponseDTO>> getAllPayments() {
        return ResponseEntity.ok(paymentService.findAll());
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<PaymentResponseDTO> getPaymentById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.findById(id));
    }

    @PostMapping
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<PaymentResponseDTO> createPayment(@Valid @RequestBody PaymentCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.create(dto));
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<PaymentResponseDTO> updatePayment(
            @PathVariable Long id,
            @Valid @RequestBody PaymentCreateDTO dto) {
        return ResponseEntity.ok(paymentService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/order/{orderId}")
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<PaymentResponseDTO>> getPaymentsByOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(paymentService.findByOrderId(orderId));
    }
}
