package com.eco.ecommerce.dto.request;

public record ProductRequest(String name, String description, Double price, Integer stock, Long categoryId) {}