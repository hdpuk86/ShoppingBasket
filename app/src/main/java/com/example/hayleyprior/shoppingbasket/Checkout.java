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

    public double discountBy(double percent, double amount){
        return this.till.discountBy(percent, amount);
    }

    public boolean customerHasLoyaltyCard(){
        return this.customer.hasLoyaltyCard();
    }

    public void applyLoyaltyDiscount(double amount) {
        if(customerHasLoyaltyCard()){
            this.till.setCurrentSaleTotal(discountBy(2, amount));
        }
    }

    public void apply10percentDiscount(){
        this.till.setCurrentSaleTotal(discountBy(10, getTotal()));
    }

    public double chargeCustomer(){
        scanAllItems(customer.getItems());
        if(getTotal() >= 20){
            apply10percentDiscount();
        }
        if(customerHasLoyaltyCard()){
            applyLoyaltyDiscount(getTotal());
        }
        return till.getCurrentSaleTotal();
    }

}
