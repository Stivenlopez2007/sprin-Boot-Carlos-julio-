package com.sena.crud_basic.controller;

import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crud_basic.dto.request.AddressCreateDTO;
import com.sena.crud_basic.dto.response.AddressResponseDTO;
import com.sena.crud_basic.dto.view.JsonViews;
import com.sena.crud_basic.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
@Tag(name = "Addresses", description = "API para gestión de direcciones")
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<AddressResponseDTO>> getAllAddresses() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<AddressResponseDTO> getAddressById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @PostMapping
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<AddressResponseDTO> createAddress(@Valid @RequestBody AddressCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.create(dto));
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<AddressResponseDTO> updateAddress(
            @PathVariable Long id,
            @Valid @RequestBody AddressCreateDTO dto) {
        return ResponseEntity.ok(addressService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/customer/{customerId}")
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<AddressResponseDTO>> getAddressesByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(addressService.findByCustomerId(customerId));
    }
}
