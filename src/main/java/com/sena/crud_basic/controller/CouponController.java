package com.sena.crud_basic.controller;

import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crud_basic.dto.request.CouponCreateDTO;
import com.sena.crud_basic.dto.response.CouponResponseDTO;
import com.sena.crud_basic.dto.view.JsonViews;
import com.sena.crud_basic.service.CouponService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
@Tag(name = "Coupons", description = "API para gestión de cupones de descuento")
public class CouponController {

    private final CouponService couponService;

    @GetMapping
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<CouponResponseDTO>> getAllCoupons() {
        return ResponseEntity.ok(couponService.findAll());
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<CouponResponseDTO> getCouponById(@PathVariable Long id) {
        return ResponseEntity.ok(couponService.findById(id));
    }

    @PostMapping
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<CouponResponseDTO> createCoupon(@Valid @RequestBody CouponCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(couponService.create(dto));
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<CouponResponseDTO> updateCoupon(
            @PathVariable Long id,
            @Valid @RequestBody CouponCreateDTO dto) {
        return ResponseEntity.ok(couponService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable Long id) {
        couponService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/code/{code}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<CouponResponseDTO> getCouponByCode(@PathVariable String code) {
        return ResponseEntity.ok(couponService.findByCode(code));
    }
}
