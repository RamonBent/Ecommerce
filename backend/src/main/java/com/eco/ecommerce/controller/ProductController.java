package com.eco.ecommerce.controller;

import com.eco.ecommerce.dto.response.ProductResponse;
import com.eco.ecommerce.dto.resquest.ProductRequest;
import com.eco.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public List<ProductResponse> list() {
        return service.listAll();
    }

    @PostMapping
    public ProductResponse create(@RequestBody ProductRequest request) {
        return service.save(request);
    }

    @GetMapping("/{id}")
    public ProductResponse get(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

