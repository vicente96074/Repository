package com.kojstarinnovations.repository.infraestructure.output.persistence.adapters;

import com.kojstarinnovations.repository.domain.model.AnimalDTO;
import com.kojstarinnovations.repository.domain.opextends.AnimalOP;
import com.kojstarinnovations.repository.infraestructure.output.persistence.entity.Animal;
import com.kojstarinnovations.repository.infraestructure.output.persistence.pmimpl.AnimalPM;
import com.kojstarinnovations.repository.infraestructure.output.persistence.repository.AnimalRepository;
import com.kojstarinnovations.repository.infraestructure.output.persistence.repository.impl.GenericRepositoryManager;
import com.kojstarinnovations.repository.infraestructure.output.persistence.repository.impl.Repository;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author vicen
 */
public class AnimalPA implements AnimalOP {

    public AnimalDTO save(AnimalDTO dto){
        return persistenceMapper.entityToDto(
                repository.save(persistenceMapper.dtoToEntity(dto))
        );
    }

    /**
     * Method to get a dto by id
     *
     * @param integer the id of the dto to be retrieved
     * @return dto with the given id
     */
    @Override
    public Optional<AnimalDTO> getById(Integer integer) {
        return repository.getById(integer)
                .map(persistenceMapper::entityToDto);
    }

    /**
     * Method to update a dto by id
     *
     * @param dto     the dto to be updated
     * @param integer the id of the dto to be updated
     * @return dto updated
     */
    @Override
    public AnimalDTO updateById(AnimalDTO dto, Integer integer) {
        return null;
    }

    /**
     * Method to delete a dto by id
     *
     * @param integer the id of the dto to be deleted
     */
    @Override
    public void deleteById(Integer integer) {

    }

    /**
     * Method to evaluate if a dto exists by id
     *
     * @param integer the id of the dto to be evaluated
     * @return boolean
     */
    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    /**
     * @param specie
     * @return
     */
    @Override
    public boolean existsBySpecie(String specie) {
        return repository.existsBySpecie(specie);
    }

    /**
     * Method to get all dto
     *
     * @return List<DTO>
     */
    @Override
    public List<AnimalDTO> getAll() {
        return repository.getAll()
                .stream()
                .map(persistenceMapper::entityToDto)
                .toList();
    }

    public static AnimalPA getInstance(Connection connection) {
        if (instance == null) {
            //Repository<Animal, Integer> repository = GenericRepositoryManager.getRepository(Animal.class, Integer.class, connection);
            AnimalRepository repository = GenericRepositoryManager.getRepository(AnimalRepository.class, connection);
            instance = new AnimalPA(repository);
        }
        return instance;
    }


    
    private AnimalPA(
            AnimalRepository repository
    ) {
        this.repository = repository;
    }
    
    public static AnimalPA instance;
    private final AnimalRepository repository;
    private final AnimalPM persistenceMapper = AnimalPM.getInstance();
}