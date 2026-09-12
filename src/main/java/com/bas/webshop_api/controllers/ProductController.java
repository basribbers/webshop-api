package com.bas.webshop_api.controllers;

import com.bas.webshop_api.data.ProductsDto;
import com.bas.webshop_api.service.ProductServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api")
public class ProductController {

    private final ProductServiceInterface productService;

    public ProductController(ProductServiceInterface productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public ProductsDto getProducts() throws IOException, InterruptedException {
        return productService.getProducts();
    }

    //dit zou altijd een post moeten zijn (er worden wijzigingen in de database doorgevoerd)
    @PostMapping("/synchronizeProducts")
    public void synchronizeProducts() throws IOException, InterruptedException {
        productService.synchronizeProducts();
    }

    @GetMapping("/searchProducts")
    public ProductsDto searchProducts(@RequestParam(required = false) String keyword) throws IOException, InterruptedException {
        return productService.searchProducts(keyword);
    }
}