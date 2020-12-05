package com.strategy.joined_table;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "petId")
public class Cat extends Animal implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "is_home_cat")
    private Boolean isHomeCat;
}
