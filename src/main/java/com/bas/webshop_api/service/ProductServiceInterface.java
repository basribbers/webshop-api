package com.bas.webshop_api.service;

import com.bas.webshop_api.data.ProductDto;
import com.bas.webshop_api.data.ProductsDto;

import java.io.IOException;

public interface ProductServiceInterface {
   public ProductsDto getProducts() throws IOException, InterruptedException;
   public void synchronizeProducts() throws IOException, InterruptedException;
   public ProductsDto searchProducts(String keyword) throws IOException, InterruptedException;;
}
