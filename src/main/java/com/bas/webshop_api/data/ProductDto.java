package com.bas.webshop_api.data;

public record ProductDto(
        Long id,
        String title,
        Double price,
        String description,
        String category) {
}