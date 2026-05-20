
# Webshop API

This is a Java Spring Boot API for a webshop.  
With this API, you can synchronize products, retrieve all products, and search for products.

Java version 25
Springboot
Maven

Start the project:
1. Start Docker desktop
2. Set up Postgressql database: docker-compose up -d
3. mvn Clean install
4. Start the application:  mvn spring-boot:run

Test: see webShop.postman_collection.json

endpoints: 

- http://localhost:8080/api/synchronizeProducts
- http://localhost:8080/api/products
- http://localhost:8080/api/searchProducts?keyword=xxx

Uitbreidingen en mogelijke verbeteringen als ik meer tijd had gehad. 

- Unittesten voor alle classes
- Api opdelen in Modules : web, persistence, domain
- Domain alleen via ports laten communiceren met de adapters
- Foutafhandeling