package com.perficient.esa.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

@Entity
@Data
public class Skill {
    @Id
    private Long id;
    @OneToOne
    private Field field;
    @Min(0)
    @Column(columnDefinition = "integer default 0")
    private Integer experience;
    private String summary;
}
