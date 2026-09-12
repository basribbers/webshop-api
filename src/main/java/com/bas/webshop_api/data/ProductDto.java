package com.bas.webshop_api.data;

import java.math.BigDecimal;

public record ProductDto(
        long id,
        String title,
        //bedragen moet altijd big decimal zijn,  double kan afrondingsverschillen  veroorzaken
        BigDecimal price,
        String description,
        String category) {
}