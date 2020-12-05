package com.strategy.table_per_class;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
public abstract class Vehicle {
    @Id
    @GeneratedValue
    private long vehicleId;

    private String manufacturer;
}
