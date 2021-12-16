package com.base;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class ProductDescription {
    @Id
    private Integer id;
    private String name;
    private String category;
    private double price;
    private Integer id_unit;
    private String description;

    public ProductDescription(int id, double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public ProductDescription() {

    }

    public int getItemID() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
