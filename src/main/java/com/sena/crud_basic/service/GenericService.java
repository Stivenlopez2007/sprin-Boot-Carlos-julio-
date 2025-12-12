package com.sena.crud_basic.service;

import java.util.List;

/**
 * Interfaz genérica para servicios CRUD.
 * Define operaciones comunes para todas las entidades.
 * 
 * @param <RequestDTO> DTO para crear/actualizar
 * @param <ResponseDTO> DTO para respuestas
 * @param <ID> Tipo del identificador (Long, Integer, etc.)
 */
public interface GenericService<RequestDTO, ResponseDTO, ID> {

    /**
     * Obtener todos los registros
     */
    List<ResponseDTO> findAll();

    /**
     * Buscar por ID
     */
    ResponseDTO findById(ID id);

    /**
     * Crear un nuevo registro
     */
    ResponseDTO create(RequestDTO dto);

    /**
     * Actualizar un registro existente
     */
    ResponseDTO update(ID id, RequestDTO dto);

    /**
     * Eliminar un registro
     */
    void delete(ID id);
}
