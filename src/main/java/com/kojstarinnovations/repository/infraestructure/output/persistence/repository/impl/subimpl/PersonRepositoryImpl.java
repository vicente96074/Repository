package com.kojstarinnovations.repository.infraestructure.output.persistence.repository.impl.subimpl;

import com.kojstarinnovations.repository.infraestructure.output.persistence.entity.Person;
import com.kojstarinnovations.repository.infraestructure.output.persistence.repository.PersonRepository;
import com.kojstarinnovations.repository.infraestructure.output.persistence.repository.impl.ReflectionUtils;
import com.kojstarinnovations.repository.infraestructure.output.persistence.repository.impl.RepositoryImpl;
import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

/**
 * Class to implement the person repository
 *
 * @Author: KojstarInnovations
 */
public class PersonRepositoryImpl extends RepositoryImpl<Person, Integer> implements PersonRepository {

    private PersonRepositoryImpl(Connection connection) {
        super(Person.class, connection);
    }

    /**
     * Method to find a person by social status
     *
     * @param socialStatus the social status of the person to be retrieved
     * @return person with the given social status
     */
    @Override
    @SneakyThrows
    public Optional<Person> getBySocialStatus(String socialStatus) {
        return findByGenericMethod(ReflectionUtils.getMethodName(), PersonRepository.class, List.of(socialStatus));
    }

    /**
     * Method to find a person by social status and branch id
     *
     * @param socialStatus the social status of the person to be retrieved
     * @param branchId     the branch id of the person to be retrieved
     * @return person with the given social status and branch id
     */
    @Override
    public Optional<Person> getBySocialStatusAndBranchId(String socialStatus, Integer branchId) {
        return findByGenericMethod(ReflectionUtils.getMethodName(), PersonRepository.class, List.of(socialStatus, branchId));
    }

    /**
     * Method to evaluate if a person exists by social status
     *
     * @param socialStatus the social status of the person to be evaluated
     * @return true if the person exists, false otherwise
     */
    @Override
    @SneakyThrows
    public boolean existsBySocialStatus(String socialStatus) {
        return existsByGenericMethod(ReflectionUtils.getMethodName(), PersonRepository.class, List.of(socialStatus));
    }

    public static PersonRepositoryImpl getInstance(Connection connection) {
        if (instance == null) {
            instance = new PersonRepositoryImpl(connection);
        }
        return instance;
    }

    private static PersonRepositoryImpl instance;
}