package com.kojstarinnovations.repository.infraestructure.output.persistence.repository;

import com.kojstarinnovations.repository.application.annotations.Param;
import com.kojstarinnovations.repository.application.annotations.Query;
import com.kojstarinnovations.repository.infraestructure.output.persistence.repository.impl.Repository;
import com.kojstarinnovations.repository.infraestructure.output.persistence.entity.Person;

import java.util.Optional;

/**
 *
 * @author vicen
 */
public interface PersonRepository extends Repository<Person, Integer> {

    /**
     * Method to find a person by social status
     *
     * @param socialStatus the social status of the person to be retrieved
     * @return person with the given social status
     */
    @Query("SELECT * FROM person WHERE social_status = ?;")
    Optional<Person> getBySocialStatus(@Param("socialStatus") String socialStatus);

    /**
     * Method to find a person by social status and branch id
     *
     * @param socialStatus the social status of the person to be retrieved
     * @param branchId the branch id of the person to be retrieved
     * @return person with the given social status and branch id
     */
    @Query("SELECT * FROM person WHERE social_status = ? AND branch_id = ?;")
    Optional<Person> getBySocialStatusAndBranchId(@Param("socialStatus") String socialStatus, @Param("branchId") Integer branchId);
    /**
     * Method to evaluate if a person exists by social status
     *
     * @param socialStatus the social status of the person to be evaluated
     * @return true if the person exists, false otherwise
     */
    @Query("SELECT CASE WHEN COUNT(p.id) > 0 THEN true ELSE false END FROM person AS p WHERE p.social_status = ?;")
    boolean existsBySocialStatus(@Param("socialStatus") String socialStatus);
}