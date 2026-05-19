package com.bas.webshop_api.config;

import com.bas.webshop_api.adapter.ProductAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration
public class ProductConfig {

    private final String endpoint;

    public ProductConfig(@Value("${fakestore.endpoint}") String endpoint) {
        this.endpoint = endpoint;
    }

    @Bean
    public HttpClient myHttpClient(){
        return HttpClient.newHttpClient();
    }

    @Bean
    public ProductAdapter productAdapter (HttpClient httpClient){
        return new ProductAdapter(httpClient,endpoint);
    }
}
