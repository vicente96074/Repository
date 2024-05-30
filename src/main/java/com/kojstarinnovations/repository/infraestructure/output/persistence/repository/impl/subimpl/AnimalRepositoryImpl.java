package com.kojstarinnovations.repository.infraestructure.output.persistence.repository.impl.subimpl;

import com.kojstarinnovations.repository.infraestructure.output.persistence.entity.Animal;
import com.kojstarinnovations.repository.infraestructure.output.persistence.repository.AnimalRepository;
import com.kojstarinnovations.repository.infraestructure.output.persistence.repository.impl.ReflectionUtils;
import com.kojstarinnovations.repository.infraestructure.output.persistence.repository.impl.RepositoryImpl;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class AnimalRepositoryImpl extends RepositoryImpl<Animal, Integer> implements AnimalRepository {


    @Override
    public Optional<Animal> findBySpecie(String specie) {
        return Optional.empty();
    }

    /**
     * Method to evaluate if an animal exists by specie
     *
     * @param specie the specie of the animal to be evaluated
     * @return true if the animal exists, false otherwise
     */
    @Override
    public boolean existsBySpecie(String specie) {
        return existsByGenericMethod(ReflectionUtils.getMethodName(), AnimalRepository.class, List.of(specie));
    }

    private AnimalRepositoryImpl(Connection connection) {
        super(Animal.class, connection);
        AnimalRepositoryImpl.connection = connection;
    }

    public static AnimalRepositoryImpl getInstance(Connection connection) {
        if (instance == null) {
            instance = new AnimalRepositoryImpl(connection);
        }
        return instance;
    }

    private static AnimalRepositoryImpl instance;
    private static Connection connection;
}
