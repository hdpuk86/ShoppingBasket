package com.example.hayleyprior.shoppingbasket;

/**
 * Created by hayleyprior on 25/11/2017.
 */

public class Till {

    public double discountBy(double percent, double originalAmount) {
        double discount = percent / 100;
        double deduction = originalAmount * discount;
        return originalAmount - deduction;
    }
}
