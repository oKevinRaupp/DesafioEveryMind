package com.kevinraupp.nunessports.DesafioEveryMind.dto;

import com.kevinraupp.nunessports.DesafioEveryMind.entities.Product;

import java.math.BigDecimal;

public class ProductDTO {

    private Long id;
    private String name;
    private String code;
    private String description;
    private BigDecimal price;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        code = product.getCode();
        description = product.getDescription();
        price = product.getPrice();
    }

    public ProductDTO(Long id, String name, String code, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}