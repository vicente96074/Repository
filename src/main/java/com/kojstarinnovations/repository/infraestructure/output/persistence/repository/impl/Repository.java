package com.kojstarinnovations.repository.infraestructure.output.persistence.repository.impl;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author vicen
 * @param <ENTITY>
 * @param <ID>
 */
public interface Repository<ENTITY, ID> {
    
    /**
     * Method to save an entity
     *
     * @param entity the entity to be saved
     * @return  the saved entity
     */
    ENTITY save(ENTITY entity);

    /**
     * Method to update an entity
     *
     * @param entity the entity to be updated
     * @return  the updated entity
     */
    ENTITY update(ENTITY entity);

    /**
     * Method to delete an entity
     *
     * @param entity the entity to be deleted
     */
    void delete(ENTITY entity);

    /**
     * Method to get an entity by id
     *
     * @param id the id of the entity to be retrieved
     * @return the entity with the given id
     */
    Optional<ENTITY> getById(ID id);

    /**
     * Method to get all entities
     *
     * @return all entities
     */
    List<ENTITY> getAll();

    /**
     * Method to get a page of entities
     *
     * @return a page of entities
     */
    Optional<ENTITY> findByGenericMethod(String methodName, Class<?> repository, List<Object> values);

    /**
     * Method to evaluate if an entity exists by generic field
     *
     * @return true if the entity exists, false otherwise
     */
    boolean existsByGenericMethod(String methodName, Class<?> repository, List<Object> values);


    /**
     * Method to evaluate if an entity exists by id
     *
     * @param id the id of the entity to be evaluated
     * @return true if the entity exists, false otherwise
     */
    boolean existsById(ID id);
}