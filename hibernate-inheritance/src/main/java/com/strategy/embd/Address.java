package com.strategy.embd;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

@Embeddable
@Data
public class Address {
    private String street;
    private Integer houseNumber;

}
