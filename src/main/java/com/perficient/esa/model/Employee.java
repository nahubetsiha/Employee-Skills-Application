package com.perficient.esa.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "uuid"
    )
    private String id;
    private String firstName;
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @Email
    private String email;
    @Email
    private String companyEmail;
    private String birthDate;
    private String hireDate;
    private Role role;
    private BusinessUnit businessUnit;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Skill> skills;

}
