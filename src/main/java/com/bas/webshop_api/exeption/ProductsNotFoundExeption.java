package com.bas.webshop_api.exeption;

public class ProductsNotFoundExeption extends RuntimeException {

    public ProductsNotFoundExeption(String message) {
        super(message);
    }
}
