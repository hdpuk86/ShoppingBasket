package com.example.hayleyprior.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by hayleyprior on 25/11/2017.
 */

public class TestCheckout {

    private Checkout checkout;
    private Customer customer;
    private Basket basket;
    private Item catFood;
    private Item tablets;
    private Till till;


    @Before
    public void setUp() throws Exception {
        basket = new Basket();
        till = new Till();
        customer = new Customer(basket, false);
        catFood = new Item("Felix", 5.50, Category.PETFOOD, true);
        tablets = new Item("Paracetamol", 2.50, Category.PHARMACY, false);

        customer.addItem(catFood);
        customer.addItem(tablets);

        checkout = new Checkout(till, customer);
    }

    @Test
    public void canCalculateTotal() throws Exception {
        ArrayList<Item> items = customer.getItems();
        checkout.scanAllItems(items);
        assertEquals(8, checkout.getTotal(), 0.1);
    }

    @Test
    public void discountsBy10PercentIfOver20() throws Exception {
        customer.emptyBasket();
        Item phone = new Item("Iphone", 100, Category.ELECTRICAL, false);
        customer.addItem(phone);
        assertEquals(90, checkout.chargeCustomer(), 0.1);
    }


}
