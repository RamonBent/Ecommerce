package com.eco.ecommerce.dto.response;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        String role
) {}
