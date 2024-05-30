package com.kojstarinnovations.repository.infraestructure.output.persistence.pmimpl;

import com.kojstarinnovations.repository.application.pm.PersistenceMapper;
import com.kojstarinnovations.repository.domain.model.AnimalDTO;
import com.kojstarinnovations.repository.infraestructure.output.persistence.entity.Animal;

public class AnimalPM implements PersistenceMapper<Animal, AnimalDTO> {
    /**
     * The method dtoToEntity
     *
     * @param dto is the data transfer object
     * @return the entity
     */
    @Override
    public Animal dtoToEntity(AnimalDTO dto) {
        Animal entity = new Animal(
                dto.getId(),
                dto.getName(),
                dto.getSpecie(),
                dto.getCamelCaseAttribute()
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
    public AnimalDTO entityToDto(Animal entity) {
        AnimalDTO dto = new AnimalDTO(
                entity.getId(),
                entity.getName(),
                entity.getSpecie(),
                entity.getCamelCaseAttribute()
        );

        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedBy(entity.getUpdatedBy());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setBranchId(entity.getBranchId());

        return dto;
    }

    private AnimalPM() {
    }

    public static AnimalPM getInstance() {
        if (instance == null) {
            instance = new AnimalPM();
        }
        return instance;
    }

    private static AnimalPM instance;
}
