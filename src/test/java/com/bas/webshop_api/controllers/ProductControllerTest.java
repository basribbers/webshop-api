package com.bas.webshop_api.controllers;

import com.bas.webshop_api.data.ProductDto;
import com.bas.webshop_api.data.ProductsDto;
import com.bas.webshop_api.service.ProductServiceInterface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    private ProductServiceInterface productService;

    @InjectMocks
    private ProductController productController;

    @Test
    void testGetProducts() throws IOException, InterruptedException {
         when(productService.getProducts()).thenReturn(provideProductDto());
         assertThat(productController.getProducts()).isEqualTo(provideProductDto());
    }

    @Test
    void testSearchProducts() throws IOException, InterruptedException {
        String keyword = "Product 2";
        when(productService.searchProducts(keyword)).thenReturn(provideProductDto());
        assertThat(productController.searchProducts(keyword)).isEqualTo(provideProductDto());
    }

    private static ProductsDto provideProductDto() {
        List<ProductDto> productList = new ArrayList<>();
        ProductDto productDto1 = new ProductDto(1L, "Product 1", new BigDecimal("10.0"), "Description 1", "Category 1");
        ProductDto productDto2 = new ProductDto(2L, "Product 2", new BigDecimal("20.0"), "Description 2", "Category 2");
        productList.add(productDto1);
        productList.add(productDto2);
        return new ProductsDto(productList);
    }
}
