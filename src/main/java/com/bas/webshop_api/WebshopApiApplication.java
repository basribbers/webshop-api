package com.bas.webshop_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bas.webshop_api")
public class WebshopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebshopApiApplication.class, args);
	}

}
