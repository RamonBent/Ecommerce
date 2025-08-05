package com.eco.ecommerce.service;

import com.eco.ecommerce.dto.request.CategoryRequestDTO;
import com.eco.ecommerce.dto.response.CategoryResponseDTO;
import com.eco.ecommerce.dto.mapper.CategoryMapper;
import com.eco.ecommerce.model.Category;
import com.eco.ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public CategoryResponseDTO create(CategoryRequestDTO dto) {
        Category category = CategoryMapper.toEntity(dto);
        category = repository.save(category);
        return CategoryMapper.toDTO(category);
    }

    public List<CategoryResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CategoryResponseDTO findById(Long id) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return CategoryMapper.toDTO(category);
    }

    public CategoryResponseDTO update(Long id, CategoryRequestDTO dto) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(dto.getName());
        category.setDescription(dto.getDescription());

        return CategoryMapper.toDTO(repository.save(category));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
