package com.bas.webshop_api.controllers;

import com.bas.webshop_api.data.ProductsDto;
import com.bas.webshop_api.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api")
public class ProductController {

private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public ProductsDto getProducts ()  {
       return productService.getProducts();
    }

    @GetMapping("/synchronizeProducts")
    public void synchronizeProducts () {
        productService.synchronizeProducts();
    }

    @GetMapping("/searchProducts")
    public ProductsDto searchProducts(@RequestParam(required = false) String keyword)  {
    return productService.searchProducts(keyword);
    }
}