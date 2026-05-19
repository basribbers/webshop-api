package com.bas.webshop_api.service;

import com.bas.webshop_api.data.ProductsDto;
import com.bas.webshop_api.entity.ProductEntity;
import com.bas.webshop_api.exeption.ProductsNotFoundExeption;
import com.bas.webshop_api.mapper.ProductDtoMapper;
import com.bas.webshop_api.mapper.ProductEntityMapper;
import com.bas.webshop_api.ports.ProductPort;
import com.bas.webshop_api.repository.ProductRepository;
import com.bas.webshop_api.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService implements ProductServiceInterface{

    private final ProductDtoMapper productMapper;
    private final ProductEntityMapper productEntityMapper;
    private final ProductPort productPort;
    private final ProductRepository productRepository;

    public ProductService(ProductDtoMapper productMapper,ProductEntityMapper productEntityMapper, ProductPort productPort, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productEntityMapper = productEntityMapper;
        this.productPort = productPort;
        this.productRepository = productRepository;
    }

    @Override
    public ProductsDto getProducts()  {
       return productMapper.mapToProductsDto( findAllProducts());
    }
    @Override
    public void synchronizeProducts()  {
        List<ProductResponse> productResponses = productPort.getResponse();
        List<ProductEntity> productEntityList = productEntityMapper.mapProductListDtoToEntityList(productResponses);
        saveAllProducts(productEntityList);
    }

    @Override
    public ProductsDto searchProducts(String keyword) {
        if (keyword==null){
            throw new ProductsNotFoundExeption("No products found, keyword is empty");
        }



        List<ProductEntity> productEntities = findAllProducts();
        List<ProductEntity> filteredProductEntities =
                productEntities.stream().filter(p ->
                contains (keyword, p.getCategory()) ||
                contains (keyword, p.getDescription()) ||
                contains (keyword, p.getTitle()) ||
                contains(keyword , p.getPrice().toString())
        ).toList();

        if (filteredProductEntities.isEmpty()){
            throw new ProductsNotFoundExeption("No products found");
        }
        return productEntityMapper.mapProductEntitiesToProductsDto(filteredProductEntities);
    }

    private void saveAllProducts(List<ProductEntity> ProductEntityList){
        productRepository.saveAll(ProductEntityList);
    }

    private List<ProductEntity>  findAllProducts(){
        return productRepository.findAll();
    }

    private boolean contains(String keyword, String field){
        return field!=null && field.toLowerCase().contains(keyword.toLowerCase());
    }
}