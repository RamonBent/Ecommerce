package com.eco.ecommerce.dto.mapper;

import com.eco.ecommerce.dto.response.ProductResponse;
import com.eco.ecommerce.dto.resquest.ProductRequest;
import com.eco.ecommerce.model.Product;
import com.eco.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    @Autowired
    private CategoryRepository categoryRepository;

    public Product toEntity(ProductRequest req) {
        Product p = new Product();
        p.setName(req.name());
        p.setDescription(req.description());
        p.setPrice(req.price());
        p.setStock(req.stock());
        p.setCategory(categoryRepository.findById(req.categoryId()).orElseThrow());
        return p;
    }

    public ProductResponse toResponse(Product p) {
        return new ProductResponse(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getPrice(),
                p.getStock(),
                p.getCategory().getName()
        );
    }
}