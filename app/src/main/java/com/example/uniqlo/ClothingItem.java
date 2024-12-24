package com.example.uniqlo;

public class ClothingItem {
    private Long id;
    private String name;
    private String category;
    private double price;
    private String brand_logo_url;
    private String media_url;
    private String description;

    // Getters and Setters
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
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getBrandLogoUrl() {
        return brand_logo_url;
    }
    public void setbrand_logo_url(String brand_logo_url) {
        this.brand_logo_url = brand_logo_url;
    }
    public String getmedia_url() {
        return media_url;
    }
    public void setmedia_url(String media_url) {
        this.media_url = media_url;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
