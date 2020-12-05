package com.strategy.single_table;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("CHOCOLATE")
public class Chocolate extends MyProduct {

    private String color;
}
