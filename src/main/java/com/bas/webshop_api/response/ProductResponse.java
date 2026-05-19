package com.bas.webshop_api.response;

public record ProductResponse(Long id,
        String title,
        Double price,
        String description,
        String category) {
}
