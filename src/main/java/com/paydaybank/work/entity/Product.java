package com.paydaybank.work.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Product extends BaseEntity {

    public Product( String name, Double price, Boolean available, String description) {
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
    private Double price;

    @Column(name = "description",length=100000)
    private String description;

    @Column(name = "available")
    private Boolean available;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
