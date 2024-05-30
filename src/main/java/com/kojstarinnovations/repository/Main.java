package com.kojstarinnovations.repository;

import com.kojstarinnovations.repository.domain.model.AnimalDTO;
import com.kojstarinnovations.repository.domain.model.PersonDTO;
import com.kojstarinnovations.repository.domain.service.AnimalService;
import com.kojstarinnovations.repository.domain.service.PersonService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Main class to test the application
 *
 * @Author: KojstarInnovations
 */
public class Main {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        
        PersonService personService = PersonService.getInstance();
        Optional<PersonDTO> personDTO = personService.getBySocialStatus("Solteroso");
        Optional<PersonDTO> personDTO2 = personService.getBySocialStatusAndBranchId("Solteroso", 2);

        if(personDTO.isPresent()){
            Logger.getLogger(Main.class.getName()).info(personDTO.get().toString());
        }else{
            Logger.getLogger(Main.class.getName()).info("No se encontró la persona");
        }

        if(personDTO2.isPresent()){
            Logger.getLogger(Main.class.getName()).info(personDTO2.get().toString());
        }else{
            Logger.getLogger(Main.class.getName()).info("No se encontró la persona por social status y branch id");
        }

        AnimalService animalService = AnimalService.getInstance();
        Optional<AnimalDTO> animalDTO = animalService.getById(1);

        if(animalDTO.isPresent()){
            Logger.getLogger(Main.class.getName()).info(animalDTO.get().toString());
        }else{
            Logger.getLogger(Main.class.getName()).info("No se encontró el animal");
        }

        boolean exists = personService.existsBySocialStatus("Solteroso");
        boolean exists2 = animalService.existsBySpecie("LagartijaXZA");
        Logger.getLogger(Main.class.getName()).info("Existe: " + exists);
        Logger.getLogger(Main.class.getName()).info("Existe: " + exists2);
    }
}