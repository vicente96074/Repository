package com.kojstarinnovations.repository.domain.model;

import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDTO extends AuditAttributesDTO{

    public PersonDTO(String name, String socialStatus, LocalDate birthDate) {
        this.name = name;
        this.socialStatus = socialStatus;
        this.birthDate = birthDate;
    }

    private Integer id;
    private String name;
    private String socialStatus;
    private LocalDate birthDate;
}