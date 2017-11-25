package com.example.hayleyprior.shoppingbasket;

/**
 * Created by hayleyprior on 25/11/2017.
 */

public class Customer {

    private Boolean hasLoyaltyCard;

    public Customer(boolean hasLoyaltyCard) {
        this.hasLoyaltyCard = hasLoyaltyCard;
    }

    public void addItem(Basket basket, Item item) {
        basket.addItem(item);
    }

    public void removeItem(Basket basket, Item item) {
        basket.removeItem(item);
    }

    public void emptyBasket(Basket basket) {
        basket.empty();
    }

    public Boolean hasLoyaltyCard() {
        return this.hasLoyaltyCard;
    }


    public void getLoyaltyCard() {
        this.hasLoyaltyCard = true;
    }

    public void loseLoyaltyCard() {
        this.hasLoyaltyCard = false;
    }
}
