package com.perficient.esa.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Employee {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @OneToOne
    private Address address;
    @Email
    private String email;
    @Email
    private String companyEmail;
    private LocalDate birthDate;
    private LocalDate hireDate;
    @Column(columnDefinition = "enum default TECHNICAL_CONSULTANT")
    private Role role;
    private BusinessUnit businessUnit;
    @OneToMany
    private List<Skill> skills;

}
