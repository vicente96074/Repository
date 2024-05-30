package com.kojstarinnovations.repository.domain.service;

import com.kojstarinnovations.repository.domain.connection.CustomizedConnection;
import com.kojstarinnovations.repository.domain.model.PersonDTO;
import com.kojstarinnovations.repository.domain.ucextends.PersonUC;
import com.kojstarinnovations.repository.infraestructure.output.persistence.adapters.PersonPA;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author vicen
 */
public class PersonService implements PersonUC {
    
    public PersonDTO save(PersonDTO dto){
         return personPA.save(
                 (PersonDTO) AuditAttributesService.getAuditAttributesForNew(dto)
         );
    }

    /**
     * Method to get a dto by id
     *
     * @param integer the id of the dto to be retrieved
     * @return dto with the given id
     */
    @Override
    public Optional<PersonDTO> getById(Integer integer) {
        return personPA.getById(integer);
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
     * Method to get a dto by social status
     *
     * @param socialStatus  the social status of the dto to be retrieved
     * @return the dto with the given social status
     */
    @Override
    public Optional<PersonDTO> getBySocialStatus(String socialStatus) {
        return personPA.getBySocialStatus(socialStatus);
    }

    @Override
    public Optional<PersonDTO> getBySocialStatusAndBranchId(String socialStatus, Integer branchId) {
        return personPA.getBySocialStatusAndBranchId(socialStatus, branchId);
    }

    /**
     * Method to evaluate if a dto exists by social status
     *
     * @param socialStatus the social status of the dto to be evaluated
     * @return true if the dto exists, false otherwise
     */
    @Override
    public boolean existsBySocialStatus(String socialStatus) {
        return personPA.existsBySocialStatus(socialStatus);
    }


    private PersonService() throws SQLException, IOException, ClassNotFoundException {
         this.personPA = PersonPA.getInstance(CustomizedConnection.getInstance().getConnection());
    }
    
    public static PersonService getInstance() throws SQLException, IOException, ClassNotFoundException {
        if (instance == null) {
            instance = new PersonService();
        }
        
        return instance;
    }
    
    private final PersonPA personPA;
    private static PersonService instance;
}