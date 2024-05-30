package com.kojstarinnovations.repository.domain.service;

import com.kojstarinnovations.repository.domain.ucextends.AnimalUC;
import com.kojstarinnovations.repository.domain.connection.CustomizedConnection;
import com.kojstarinnovations.repository.domain.model.AnimalDTO;
import com.kojstarinnovations.repository.infraestructure.output.persistence.adapters.AnimalPA;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author vicen
 */
public class AnimalService implements AnimalUC {
    
   public AnimalDTO save(AnimalDTO dto){
         return animalPA.save(
                 (AnimalDTO) AuditAttributesService.getAuditAttributesForNew(dto)
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
        return animalPA.getById(integer);
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
        return animalPA.existsBySpecie(specie);
    }

    /**
     * Method to get all dto
     *
     * @return List<DTO>
     */
    @Override
    public List<AnimalDTO> getAll() {
        return List.of();
    }

    private AnimalService() throws SQLException, IOException, ClassNotFoundException {
         this.animalPA = AnimalPA.getInstance(CustomizedConnection.getInstance().getConnection());
    }
    
    public static AnimalService getInstance() throws SQLException, IOException, ClassNotFoundException {
        if (instance == null) {
            instance = new AnimalService();
        }
        
        return instance;
    }
    

    private static AnimalService instance;
    private final AnimalPA animalPA;
}
