package com.eco.ecommerce.service;

import com.eco.ecommerce.dto.mapper.ProductMapper;
import com.eco.ecommerce.dto.response.ProductResponse;
import com.eco.ecommerce.dto.request.ProductRequest;
import com.eco.ecommerce.model.Product;
import com.eco.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private ProductMapper mapper;

    public List<ProductResponse> listAll() {
        return productRepo.findAll().stream().map(mapper::toResponse).toList();
    }

    public ProductResponse save(ProductRequest req) {
        Product p = mapper.toEntity(req);
        productRepo.save(p);
        return mapper.toResponse(p);
    }

    public ProductResponse findById(Long id) {
        return mapper.toResponse(productRepo.findById(id).orElseThrow());
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }
}
