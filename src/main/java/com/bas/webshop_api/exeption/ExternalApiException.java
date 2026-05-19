package com.bas.webshop_api.exeption;

public class ExternalApiException extends RuntimeException {

    public ExternalApiException(String message, Throwable e) {
        super(message,e);
    }
}
