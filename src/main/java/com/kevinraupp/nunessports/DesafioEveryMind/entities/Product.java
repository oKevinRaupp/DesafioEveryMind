package com.kevinraupp.nunessports.DesafioEveryMind.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "produtos")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", unique = false, length = 50, nullable = false)
    private String name;
    @Column(name = "codigo", unique = false, length = 10, nullable = false)
    private String code;
    @Column(name = "descricao", unique = false, length = 200, nullable = false)
    private String description;
    @Column(name = "preco", unique = false, length = 20, nullable = false)
    private BigDecimal price;

    public Product() {
    }

    public Product(Long id, String name, String code, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public Product(String name, String code, String description, BigDecimal price) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(code, product.code) && Objects.equals(description, product.description) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, description, price);
    }

    @Override
    public String toString() {
        return "PRODUTO [" + " id = " + id +
                " | nome = " + name +
                " | código = " + code +
                " | descrição = " + description
                + " | preço = " + price
                + " ]";
    }
}