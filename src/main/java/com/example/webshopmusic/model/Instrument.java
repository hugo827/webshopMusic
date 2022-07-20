package com.example.webshopmusic.model;

public class Instrument {

    private int id;
    private String name;
    private String description;
    private double price;
    private String fkCategory;
    private int fkBrand;

    public Instrument() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFkCategory() {
        return fkCategory;
    }

    public void setFkCategory(String fkCategory) {
        this.fkCategory = fkCategory;
    }

    public int getFkBrand() {
        return fkBrand;
    }

    public void setFkBrand(int fkBrand) {
        this.fkBrand = fkBrand;
    }
}
