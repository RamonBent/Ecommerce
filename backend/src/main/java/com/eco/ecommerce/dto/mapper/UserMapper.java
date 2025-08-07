package com.eco.ecommerce.dto.mapper;

import com.eco.ecommerce.dto.request.UserRequestDTO;
import com.eco.ecommerce.dto.response.UserResponseDTO;
import com.eco.ecommerce.model.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setRole(dto.role());
        return user;
    }

    public static UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
}