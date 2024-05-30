package com.kojstarinnovations.repository.domain.ucextends;

import com.kojstarinnovations.repository.application.usecase.UseCase;
import com.kojstarinnovations.repository.domain.model.AnimalDTO;

public interface AnimalUC extends UseCase<AnimalDTO, Integer> {
    boolean existsBySpecie(String specie);
}
