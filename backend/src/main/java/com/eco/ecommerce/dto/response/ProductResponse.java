package com.eco.ecommerce.dto.response;

public record ProductResponse(Long id, String name, String description, Double price, Integer stock, String categoryName) {}