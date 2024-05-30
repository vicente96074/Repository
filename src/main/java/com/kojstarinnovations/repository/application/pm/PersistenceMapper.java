package com.kojstarinnovations.repository.application.pm;

/**
 * PersistenceMapper
 *
 * @param <ENTITY>
 * @param <DTO>
 *
 * @Author: KojstarInnovations
 */
public interface PersistenceMapper <ENTITY, DTO> {

    /**
     * The method dtoToEntity
     * @param dto is the data transfer object
     * @return the entity
     */
    public ENTITY dtoToEntity(DTO dto);

    /**
     * The method entityToDto
     *
     * @param entity is the entity
     * @return the data transfer object
     */
    public DTO entityToDto(ENTITY entity);
}