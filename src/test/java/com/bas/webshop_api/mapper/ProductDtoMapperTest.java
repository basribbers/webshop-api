package com.bas.webshop_api.mapper;

import com.bas.webshop_api.data.ProductDto;
import com.bas.webshop_api.data.ProductsDto;
import com.bas.webshop_api.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

    class ProductDtoMapperTest {

        private final ProductDtoMapper mapper = Mappers.getMapper(ProductDtoMapper.class);

        @Test
        void shouldMapEntityToDto() {
            ProductEntity entity = new ProductEntity();
            entity.setCategory("Kleding");
            entity.setDescription("Een lange broek");
            entity.setPrice(new BigDecimal("100.1"));
            entity.setId(1L);
            ProductDto dto = mapper.toDto(entity);

            assertThat(dto.id()).isEqualTo(entity.getId());
            assertThat(dto.category()).isEqualTo(entity.getCategory());
            assertThat(dto.description()).isEqualTo(entity.getDescription());
            assertThat(dto.price()).isEqualTo(entity.getPrice());
        }
}