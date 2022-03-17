package com.hit.recyclerview;

public class Product {
    private Integer image;
    private String type;
    private String name;
    private Integer price;

    public Product(Integer image, String type, String name, Integer price) {
        this.image = image;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
}
