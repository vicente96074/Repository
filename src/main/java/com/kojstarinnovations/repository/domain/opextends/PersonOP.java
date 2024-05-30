package com.kojstarinnovations.repository.domain.opextends;

import com.kojstarinnovations.repository.application.outputport.OutputPort;
import com.kojstarinnovations.repository.domain.model.PersonDTO;

import java.util.Optional;

public interface PersonOP extends OutputPort<PersonDTO, Integer> {

    /**
     * Method to get a dto by social security number
     *
     * @param socialStatus the social security number of the dto to be retrieved
     * @return dto with the given social security number
     */
    Optional<PersonDTO> getBySocialStatus(String socialStatus);

    /**
     * Method to get a dto by social security number and branch id
     *
     * @param socialStatus the social security number of the dto to be retrieved
     * @param branchId the branch id of the dto to be retrieved
     * @return dto with the given social security number and branch id
     */
    Optional<PersonDTO> getBySocialStatusAndBranchId(String socialStatus, Integer branchId);

    /**
     * Method to evaluate if a dto exists by social security number
     *
     * @param socialStatus the social security number of the dto to be evaluated
     * @return true if the dto exists, false otherwise
     */
    boolean existsBySocialStatus(String socialStatus);
}