package com.paydaybank.work.entity;


import javax.persistence.*;
@Entity
public class Product extends BaseEntity {

    public Product( String name, Integer price, Boolean available, String description) {
        this.name = name;
        this.price = price;
        this.available= available;
        this.description = description;
    }

    public Product() {
    }

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="price", nullable = false)
    private Integer price;

    @Column(name = "description")
    private String description;

    @Column(name = "available")
    private Boolean available;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
