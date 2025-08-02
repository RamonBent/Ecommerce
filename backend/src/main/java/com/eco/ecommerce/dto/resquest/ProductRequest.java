package com.eco.ecommerce.dto.resquest;

public record ProductRequest(String name, String description, Double price, Integer stock, Long categoryId) {}