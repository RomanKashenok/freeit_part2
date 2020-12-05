package com.strategy.single_table;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.STRING)
public class MyProduct {
    @Id
    @GeneratedValue
    private Long productId;
    private String name;
}
