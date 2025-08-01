package com.eco.ecommerce.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Address {
    private Long id;
    private String street;
    private String city;
    private String zipCode;
    private String state;
    private String country;
}
