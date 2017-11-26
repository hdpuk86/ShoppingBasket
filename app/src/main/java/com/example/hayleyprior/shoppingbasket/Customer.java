package com.example.hayleyprior.shoppingbasket;

import java.util.ArrayList;

/**
 * Created by hayleyprior on 25/11/2017.
 */

public class Customer {

    private Basket customerBasket;
    private Boolean hasLoyaltyCard;

    public Customer(Basket basket, boolean hasLoyaltyCard) {
        this.customerBasket = basket;
        this.hasLoyaltyCard = hasLoyaltyCard;
    }

    public void addItem(Item item) {
        this.customerBasket.addItem(item);
    }

    public void removeItem(Item item) {
        this.customerBasket.removeItem(item);
    }

    public void emptyBasket() {
        this.customerBasket.empty();
    }

    public Boolean hasLoyaltyCard() {
        return this.hasLoyaltyCard;
    }

    public void aquireLoyaltyCard() {
        this.hasLoyaltyCard = true;
    }

    public void loseLoyaltyCard() {
        this.hasLoyaltyCard = false;
    }

    public ArrayList<Item> getItems() {
        return new ArrayList<>(this.customerBasket.getItems());
    }
}
