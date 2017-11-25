package com.example.hayleyprior.shoppingbasket;

import java.util.ArrayList;

/**
 * Created by hayleyprior on 25/11/2017.
 */

public class Basket {

    private ArrayList<Item> items;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public int countItems() {
        return this.items.size();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return new ArrayList<>(items);
    }

    public void empty() {
        this.items.clear();
    }
}
