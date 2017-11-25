package com.example.hayleyprior.shoppingbasket;

/**
 * Created by hayleyprior on 25/11/2017.
 */

public class Item {
    private String name;
    private double price;
    private Category category;
    private Boolean onBOGOF;

    public Item(String name, double price, Category category, Boolean onBOGOF) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.onBOGOF = onBOGOF;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public Boolean getOnBOGOF() {
        return onBOGOF;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOnBOGOF(Boolean onBOGOF) {
        this.onBOGOF = onBOGOF;
    }
}
