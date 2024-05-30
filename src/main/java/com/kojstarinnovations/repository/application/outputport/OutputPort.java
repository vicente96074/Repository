package com.kojstarinnovations.repository.application.outputport;

import java.util.List;
import java.util.Optional;

/**
 * Output port interface
 * @param <DTO> the dto type
 * @param <ID> the id type
 *
 * @Author: KojstarInnovations
 */
public interface OutputPort<DTO, ID> {

    /**
     * Method to save a dto
     *
     * @param dto the dto to be saved
     * @return dto
     */
    DTO save(DTO dto);

    /**
     * Method to get a dto by id
     *
     * @param id the id of the dto to be retrieved
     * @return dto with the given id
     */
    Optional<DTO> getById(ID id);

    /**
     * Method to update a dto by id
     *
     * @param dto the dto to be updated
     * @param id the id of the dto to be updated
     * @return dto updated
     */
    DTO updateById(DTO dto, ID id);

    /**
     * Method to delete a dto by id
     *
     * @param id the id of the dto to be deleted
     */
    void deleteById(ID id);

    /**
     * Method to evaluate if a dto exists by id
     *
     * @param id the id of the dto to be evaluated
     * @return boolean
     */
    boolean existsById(ID id);

    /**
     * Method to get all dto
     *
     * @return List<DTO>
     */
    List<DTO> getAll();
}