package com.bas.webshop_api.mapper;

import com.bas.webshop_api.data.ProductDto;
import com.bas.webshop_api.data.ProductsDto;
import com.bas.webshop_api.entity.ProductEntity;
import com.bas.webshop_api.response.ProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {

    ProductDto toDto(ProductEntity entity);
    List<ProductDto> toDtoList(List<ProductEntity> entities);
    default ProductsDto mapToProductsDto(List<ProductEntity> entity) {
        return new ProductsDto(toDtoList(entity));
    }


}
