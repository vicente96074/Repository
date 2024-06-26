package com.kojstarinnovations.repository.infraestructure.output.persistence.entity;

import com.kojstarinnovations.repository.application.annotations.AutoGenerated;
import com.kojstarinnovations.repository.application.annotations.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 *
 * @author vicen
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person extends AuditAttributes {

    public Person(String name, String socialStatus, LocalDate birthDate) {
        this.name = name;
        this.socialStatus = socialStatus;
        this.birthDate = birthDate;
    }

    @Id
    @AutoGenerated
    private Integer id;

    private String name;
    private String socialStatus;
    private LocalDate birthDate;
}