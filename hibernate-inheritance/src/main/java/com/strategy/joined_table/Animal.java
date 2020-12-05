package com.strategy.joined_table;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue
    private long animalId;
    private String species;
}