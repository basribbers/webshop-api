package com.bas.webshop_api.response;

import java.math.BigDecimal;

public record ProductResponse(Long id,
              String title,
              BigDecimal price,
              String description,
              String category) {
}
