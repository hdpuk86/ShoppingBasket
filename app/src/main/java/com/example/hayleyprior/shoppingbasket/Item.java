package com.example.hayleyprior.shoppingbasket;

/**
 * Created by hayleyprior on 25/11/2017.
 */

public class Item {

    private String name;
    private double price;
    private Boolean onBOGOF;

    public Item(String name, double price, Boolean onBOGOF) {
        this.name = name;
        this.price = price;
        this.onBOGOF = onBOGOF;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Boolean getOnBOGOF() {
        return onBOGOF;
    }

}
