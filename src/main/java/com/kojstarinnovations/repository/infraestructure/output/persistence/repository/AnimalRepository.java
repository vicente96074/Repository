package com.kojstarinnovations.repository.infraestructure.output.persistence.repository;

import com.kojstarinnovations.repository.application.annotations.Param;
import com.kojstarinnovations.repository.application.annotations.Query;
import com.kojstarinnovations.repository.infraestructure.output.persistence.repository.impl.Repository;
import com.kojstarinnovations.repository.infraestructure.output.persistence.entity.Animal;

import java.util.Optional;

/**
 * The interface Animal repository.
 *
 * @author vicen
 */
public interface AnimalRepository extends Repository<Animal, Integer> {

    /**
     * Method to find an animal by specie
     *
     * @param specie the specie of the animal to be retrieved
     * @return animal with the given specie
     */
    Optional<Animal> findBySpecie(String specie);

    /**
     * Method to evaluate if an animal exists by specie
     *
     * @param specie the specie of the animal to be evaluated
     * @return true if the animal exists, false otherwise
     */
    @Query("SELECT CASE WHEN COUNT(a.id) > 0 THEN true ELSE false END FROM animal AS a WHERE a.specie = ?;")
    boolean existsBySpecie(@Param("specie") String specie);
}