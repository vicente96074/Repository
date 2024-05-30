package com.kojstarinnovations.repository.infraestructure.output.persistence.repository.impl;

import com.kojstarinnovations.repository.infraestructure.output.persistence.repository.AnimalRepository;
import com.kojstarinnovations.repository.infraestructure.output.persistence.repository.PersonRepository;
import com.kojstarinnovations.repository.infraestructure.output.persistence.repository.impl.subimpl.AnimalRepositoryImpl;
import com.kojstarinnovations.repository.infraestructure.output.persistence.repository.impl.subimpl.PersonRepositoryImpl;

import java.sql.Connection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GenericRepositoryManager {
    private static final Map<Class<?>, RepositoryImpl<?, ?>> repositories = new ConcurrentHashMap<>();

    private GenericRepositoryManager() {}

    @SuppressWarnings("unchecked")
    public static <REPO> REPO getRepository(Class<REPO> repositoryClass, Connection connection) {
        return (REPO) repositories.computeIfAbsent(repositoryClass, key -> {
            if (repositoryClass == AnimalRepository.class) {
                return AnimalRepositoryImpl.getInstance(connection);
            } else if (repositoryClass == PersonRepository.class) {
                return PersonRepositoryImpl.getInstance(connection);
            } else{
                throw new IllegalArgumentException("Unknown repository: " + repositoryClass);
            }
        });
    }
}