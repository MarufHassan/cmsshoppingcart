package com.marufhassan.cmsshoppingcart.models;

import lombok.Data;

@Data
public class Cart {
    private int id;
    private String name;
    private String price;
    private String quantity;
    private String image;

    public Cart(int id, String name, String price, String quantity, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }
}
