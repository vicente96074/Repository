package com.kojstarinnovations.repository.domain.ucextends;

import com.kojstarinnovations.repository.application.usecase.UseCase;
import com.kojstarinnovations.repository.domain.model.PersonDTO;

import java.util.Optional;

public interface PersonUC extends UseCase<PersonDTO, Integer> {

    /**
     * Method to get a dto by social status
     *
     * @param socialStatus  the social status of the dto to be retrieved
     * @return the dto with the given social status
     */
    Optional<PersonDTO> getBySocialStatus(String socialStatus);

    /**
     * Method to get a dto by social status and branch id
     *
     * @param socialStatus  the social status of the dto to be retrieved
     * @param branchId      the branch id of the dto to be retrieved
     * @return the dto with the given social status and branch id
     */
    Optional<PersonDTO> getBySocialStatusAndBranchId(String socialStatus, Integer branchId);

    /**
     * Method to evaluate if a dto exists by social status
     *
     * @param socialStatus  the social status of the dto to be evaluated
     * @return true if the dto exists, false otherwise
     */
    boolean existsBySocialStatus(String socialStatus);
}