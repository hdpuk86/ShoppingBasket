package com.example.hayleyprior.shoppingbasket;

/**
 * Created by hayleyprior on 25/11/2017.
 */

public class Till {

    private double currentSaleTotal;

    public Till() {
        this.currentSaleTotal = 0;
    }

    public double discountBy(double percent, double originalAmount) {
        double discount = percent / 100;
        double deduction = originalAmount * discount;
        return originalAmount - deduction;
    }

    public void addToTotal(double amount) {
        this.currentSaleTotal += amount;
    }

    public double getCurrentSaleTotal() {
        return currentSaleTotal;
    }

    public void setCurrentSaleTotal(double newAmount) {
        this.currentSaleTotal = newAmount;
    }

    public double bogofDiscountEven(Item item, int numberOfItems){
        return numberOfItems / 2 * item.getPrice();
    }

    public double bogofDiscountOdd(Item item, int numberOfItems){
        return (numberOfItems - 1) / 2 * item.getPrice() + item.getPrice();
    }
}
