package com.example.hayleyprior.shoppingbasket;

import java.util.ArrayList;

/**
 * Created by hayleyprior on 25/11/2017.
 */

public class Checkout {

    private Till till;
    private Customer customer;

    public Checkout(Till till, Customer customer) {
        this.till = till;
        this.customer = customer;
    }

    public void scanAllItems(ArrayList<Item> items){
        for(Item item : items){
            this.till.addToTotal(item.getPrice());
        }
    }

    public double getTotal() {
        return this.till.getCurrentSaleTotal();
    }

    public double discount10Percent(double amount){
        return this.till.discountBy(10, amount);
    }

    public double chargeCustomer(){
        scanAllItems(customer.getItems());
        if(getTotal() >= 20){
            double discountedPrice = discount10Percent(getTotal());
            this.till.setCurrentSaleTotal(discountedPrice);
        }
        return till.getCurrentSaleTotal();
    }
}
