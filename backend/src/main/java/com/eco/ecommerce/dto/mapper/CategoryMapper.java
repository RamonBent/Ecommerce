package com.eco.ecommerce.dto.mapper;

import com.eco.ecommerce.model.Category;
import com.eco.ecommerce.dto.request.CategoryRequestDTO;
import com.eco.ecommerce.dto.response.CategoryResponseDTO;

public class CategoryMapper {

    public static Category toEntity(CategoryRequestDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;
    }

    public static CategoryResponseDTO toDTO(Category category) {
        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        return dto;
    }
}