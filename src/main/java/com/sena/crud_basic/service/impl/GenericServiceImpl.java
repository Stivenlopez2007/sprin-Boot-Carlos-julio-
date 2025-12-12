package com.sena.crud_basic.service.impl;

import com.sena.crud_basic.service.GenericService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación genérica abstracta para servicios CRUD.
 * Las clases hijas deben implementar los métodos de mapeo.
 * 
 * @param <Entity> Entidad JPA
 * @param <RequestDTO> DTO para crear/actualizar
 * @param <ResponseDTO> DTO para respuestas
 * @param <ID> Tipo del identificador
 */
@Transactional
public abstract class GenericServiceImpl<Entity, RequestDTO, ResponseDTO, ID> 
        implements GenericService<RequestDTO, ResponseDTO, ID> {

    /**
     * Obtener el repositorio específico de la entidad.
     * Debe ser implementado por las clases hijas.
     */
    protected abstract JpaRepository<Entity, ID> getRepository();

    /**
     * Mapear de RequestDTO a Entity.
     * Debe ser implementado por las clases hijas.
     */
    protected abstract Entity mapToEntity(RequestDTO dto);

    /**
     * Mapear de Entity a ResponseDTO.
     * Debe ser implementado por las clases hijas.
     */
    protected abstract ResponseDTO mapToResponse(Entity entity);

    /**
     * Actualizar entity con datos del RequestDTO.
     * Debe ser implementado por las clases hijas.
     */
    protected abstract void updateEntity(Entity entity, RequestDTO dto);

    /**
     * Obtener nombre de la entidad para mensajes de error.
     */
    protected abstract String getEntityName();

    @Override
    @Transactional(readOnly = true)
    public List<ResponseDTO> findAll() {
        return getRepository().findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseDTO findById(ID id) {
        Entity entity = getRepository().findById(id)
                .orElseThrow(() -> new RuntimeException(
                        getEntityName() + " no encontrado con ID: " + id));
        return mapToResponse(entity);
    }

    @Override
    public ResponseDTO create(RequestDTO dto) {
        Entity entity = mapToEntity(dto);
        Entity saved = getRepository().save(entity);
        return mapToResponse(saved);
    }

    @Override
    public ResponseDTO update(ID id, RequestDTO dto) {
        Entity entity = getRepository().findById(id)
                .orElseThrow(() -> new RuntimeException(
                        getEntityName() + " no encontrado con ID: " + id));
        
        updateEntity(entity, dto);
        Entity updated = getRepository().save(entity);
        return mapToResponse(updated);
    }

    @Override
    public void delete(ID id) {
        if (!getRepository().existsById(id)) {
            throw new RuntimeException(
                    getEntityName() + " no encontrado con ID: " + id);
        }
        getRepository().deleteById(id);
    }
}
