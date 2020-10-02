package com.perficient.esa.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "uuid"
    )
    private String id;
    private String street;
    private String suite;
    private String city;
    private String region;
//    @Pattern(regexp = "\\D{2,3}")
    private String postal;
//    @Pattern(regexp = "\\D{2}")
    private String country;
}
