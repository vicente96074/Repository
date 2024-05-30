package com.kojstarinnovations.repository.infraestructure.output.persistence.pmimpl;

import com.kojstarinnovations.repository.application.pm.PersistenceMapper;
import com.kojstarinnovations.repository.domain.model.PersonDTO;
import com.kojstarinnovations.repository.infraestructure.output.persistence.entity.Person;

public class PersonPM implements PersistenceMapper<Person, PersonDTO> {

    /**
     * The method dtoToEntity
     *
     * @param dto is the data transfer object
     * @return the entity
     */
    @Override
    public Person dtoToEntity(PersonDTO dto) {
        Person entity = new Person(
                dto.getName(),
                dto.getSocialStatus(),
                dto.getBirthDate()
        );

        entity.setCreatedBy(dto.getCreatedBy());
        entity.setUpdatedBy(dto.getUpdatedBy());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setBranchId(dto.getBranchId());

        return entity;
    }

    /**
     * The method entityToDto
     *
     * @param entity is the entity
     * @return the data transfer object
     */
    @Override
    public PersonDTO entityToDto(Person entity) {
        PersonDTO dto = new PersonDTO(
                entity.getId(),
                entity.getName(),
                entity.getSocialStatus(),
                entity.getBirthDate()
        );

        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedBy(entity.getUpdatedBy());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setBranchId(entity.getBranchId());

        return dto;
    }

    private PersonPM() {
    }

    public static PersonPM getInstance() {
        if (instance == null) {
            instance = new PersonPM();
        }
        return instance;
    }

    private static PersonPM instance;
}