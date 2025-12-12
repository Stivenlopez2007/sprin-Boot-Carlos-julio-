package com.sena.crud_basic.controller;

import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crud_basic.dto.request.CustomerCreateDTO;
import com.sena.crud_basic.dto.request.CustomerUpdateDTO;
import com.sena.crud_basic.dto.response.CustomerResponseDTO;
import com.sena.crud_basic.dto.view.JsonViews;
import com.sena.crud_basic.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Tag(name = "Customers", description = "API para gestión de clientes")
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "Obtener todos los clientes", description = "Retorna lista de clientes con vista resumida")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente")
    })
    @GetMapping
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @Operation(summary = "Obtener cliente por ID", description = "Retorna un cliente específico con vista detallada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    @GetMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @Operation(summary = "Crear nuevo cliente", description = "Crea un nuevo cliente en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody CustomerCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(dto));
    }

    @Operation(summary = "Actualizar cliente", description = "Actualiza los datos de un cliente existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente actualizado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PutMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<CustomerResponseDTO> updateCustomer(
            @PathVariable Long id,
            @Valid @RequestBody CustomerUpdateDTO dto) {
        return ResponseEntity.ok(customerService.update(id, dto));
    }

    @Operation(summary = "Eliminar cliente", description = "Elimina un cliente del sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Cliente eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar clientes por nombre", description = "Busca clientes que contengan el nombre especificado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Búsqueda realizada exitosamente")
    })
    @GetMapping("/search")
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<CustomerResponseDTO>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(customerService.filterByName(name));
    }

}
