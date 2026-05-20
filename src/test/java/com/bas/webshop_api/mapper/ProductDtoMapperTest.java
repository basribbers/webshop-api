package com.bas.webshop_api.mapper;

import com.bas.webshop_api.data.ProductDto;
import com.bas.webshop_api.data.ProductsDto;
import com.bas.webshop_api.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

    class ProductDtoMapperTest {

        private final ProductDtoMapper mapper = Mappers.getMapper(ProductDtoMapper.class);

        @Test
        void shouldMapEntityToDto() {

            ProductEntity entity = new ProductEntity();
            entity.setCategory("Kleding");
            entity.setDescription("Een lange broek");
            entity.setPrice(100.10);
            entity.setId(1l);

            ProductDto dto = mapper.toDto(entity);

            assertNotNull(dto);
            assertEquals(entity.getId(), dto.id());
            assertEquals(entity.getCategory(), dto.category());
            assertEquals(entity.getDescription(), dto.description());
            assertEquals(entity.getPrice(), dto.price());
        }
}
