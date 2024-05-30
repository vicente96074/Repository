package com.kojstarinnovations.repository.domain.model;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnimalDTO extends AuditAttributesDTO{
    private Integer id;
    private String name;
    private String specie;
    private String camelCaseAttribute;
}