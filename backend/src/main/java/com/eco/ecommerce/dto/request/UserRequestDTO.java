package com.eco.ecommerce.dto.request;

public record UserRequestDTO(
        String name,
        String email,
        String password,
        String role
) {}
