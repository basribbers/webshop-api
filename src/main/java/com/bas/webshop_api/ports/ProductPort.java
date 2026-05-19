package com.bas.webshop_api.ports;

import com.bas.webshop_api.response.ProductResponse;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public interface ProductPort {
    public List<ProductResponse> getResponse() ;

}
