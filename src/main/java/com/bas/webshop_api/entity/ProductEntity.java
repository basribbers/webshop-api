package com.bas.webshop_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class ProductEntity {

    public ProductEntity(){}

    @Id
    private Long id;
    private String title;
    private Double price;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String category;
}


