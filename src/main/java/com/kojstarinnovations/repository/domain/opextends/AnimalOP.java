package com.kojstarinnovations.repository.domain.opextends;

import com.kojstarinnovations.repository.application.outputport.OutputPort;
import com.kojstarinnovations.repository.domain.model.AnimalDTO;

/**
 * The interface Animal op.
 *
 * This interface is used to define the output port for the Animal entity.
 */
public interface AnimalOP extends OutputPort<AnimalDTO, Integer> {

    boolean existsBySpecie(String specie);
}