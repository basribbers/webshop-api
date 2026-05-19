package com.bas.webshop_api.mapper;

import com.bas.webshop_api.data.ProductDto;
import com.bas.webshop_api.data.ProductsDto;
import com.bas.webshop_api.entity.ProductEntity;
import com.bas.webshop_api.response.ProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface ProductEntityMapper {

    public ProductEntity mapProductDtoToEntity (ProductResponse productResponse);
    public List<ProductEntity> mapProductListDtoToEntityList(List<ProductResponse> productResponseList);

    public ProductDto mapProductEntityToProductDto (ProductEntity productEntity);
    public List<ProductDto> mapEntityListToProductDtoList(List<ProductEntity> productEntityList);

    default ProductsDto mapProductEntitiesToProductsDto(List<ProductEntity> entities) {
        return new ProductsDto(mapEntityListToProductDtoList(entities));
    }
}
