package com.perficient.esa.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Field {
    @Id
    private Long id;
    private String name;
    private String type;
}
