package com.perficient.esa.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Data
public class Skill {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "uuid"
    )
    private String id;
    @OneToOne(cascade = CascadeType.ALL)
    private Field field;
    @Min(0)
    private Integer experience;
    private String summary;
}
