package com.eco.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role; // CLIENT, ADMIN

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany
    private List<Address> addresses;
}
