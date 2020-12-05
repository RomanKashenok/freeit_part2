package com.strategy.mapped_superclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Barista extends Person {

    @Column(name = "age")
    private Integer age;

    @Column(name = "occ")
    private String occupation;
}
