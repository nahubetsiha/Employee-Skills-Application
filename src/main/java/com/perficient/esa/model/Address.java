package com.perficient.esa.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class Address {
    @Id
    private Long id;
    private String street;
    private String suite;
    private String city;
    private String region;
    @Pattern(regexp = "\\D{2,3}")
    private String postal;
    @Pattern(regexp = "\\D{2}")
    private String country;
}
