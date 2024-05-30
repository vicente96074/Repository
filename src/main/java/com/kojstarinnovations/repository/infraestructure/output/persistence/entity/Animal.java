package com.kojstarinnovations.repository.infraestructure.output.persistence.entity;

import com.kojstarinnovations.repository.application.annotations.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author vicen
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Animal extends AuditAttributes{

    @Id
    private Integer id;
    private String name;
    private String specie;
    private String camelCaseAttribute;
}