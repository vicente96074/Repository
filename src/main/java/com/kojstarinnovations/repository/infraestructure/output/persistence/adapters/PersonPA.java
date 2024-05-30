package com.kojstarinnovations.repository.infraestructure.output.persistence.adapters;

import com.kojstarinnovations.repository.domain.model.PersonDTO;
import com.kojstarinnovations.repository.domain.opextends.PersonOP;
import com.kojstarinnovations.repository.infraestructure.output.persistence.pmimpl.PersonPM;
import com.kojstarinnovations.repository.infraestructure.output.persistence.repository.PersonRepository;
import com.kojstarinnovations.repository.infraestructure.output.persistence.repository.impl.GenericRepositoryManager;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author vicen
 */
public class PersonPA implements PersonOP {
    
    public PersonDTO save(PersonDTO dto){
        return persistenceMapper.entityToDto(
                repository.save(persistenceMapper.dtoToEntity(dto))
        );
    }

    /**
     * Method to get a dto by id
     *
     * @param id the id of the dto to be retrieved
     * @return dto with the given id
     */
    @Override
    public Optional<PersonDTO> getById(Integer id) {
        return repository.getById(id)
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
    public PersonDTO updateById(PersonDTO dto, Integer integer) {
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
     * Method to get all dto
     *
     * @return List<DTO>
     */
    @Override
    public List<PersonDTO> getAll() {
        return List.of();
    }

    /**
     * Method to get a dto by social security number
     *
     * @param socialStatus the social security number of the dto to be retrieved
     * @return dto with the given social security number
     */
    @Override
    public Optional<PersonDTO> getBySocialStatus(String socialStatus) {
        return repository.getBySocialStatus(socialStatus)
                .map(persistenceMapper::entityToDto);
    }

    /**
     * Method to get a dto by social security number and branch id
     *
     * @param socialStatus the social security number of the dto to be retrieved
     * @param branchId the branch id of the dto to be retrieved
     * @return dto with the given social security number and branch id
     */
    @Override
    public Optional<PersonDTO> getBySocialStatusAndBranchId(String socialStatus, Integer branchId) {
        return repository.getBySocialStatusAndBranchId(socialStatus, branchId)
                .map(persistenceMapper::entityToDto);
    }

    /**
     * Method to evaluate if a dto exists by social security number
     *
     * @param socialStatus the social security number of the dto to be evaluated
     * @return true if the dto exists, false otherwise
     */
    @Override
    public boolean existsBySocialStatus(String socialStatus) {
        return repository.existsBySocialStatus(socialStatus);
    }

    public static PersonPA getInstance(Connection connection) {
        if (instance == null) {
            //Repository<Person, Integer> repository = GenericRepositoryManager.getRepository(Person.class, Integer.class, connection);
            PersonRepository repository = GenericRepositoryManager.getRepository(PersonRepository.class, connection);
            instance = new PersonPA(repository);
        }
        return instance;
    }
    
     private PersonPA(
             PersonRepository repository
     ) {
        this.repository = repository;
    }
    
    
    
    public static PersonPA instance;
    
    //private final Repository<Person, Integer> repository;
    private final PersonRepository repository;
    private final PersonPM persistenceMapper = PersonPM.getInstance();
}