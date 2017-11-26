package com.example.hayleyprior.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by hayleyprior on 25/11/2017.
 */

public class TestCheckout {

    private Checkout checkout;
    private Customer customer;
    private Item catFood;
    private Item tablets;
    private Till till;

    @Before
    public void setUp() throws Exception {
        Basket basket = new Basket();
        till = new Till();
        catFood = new Item("Felix", 5.50, true);
        tablets = new Item("Paracetamol", 2.50, false);
        customer = new Customer(basket, false);
        customer.addItem(catFood);
        customer.addItem(tablets);
        checkout = new Checkout(till, customer);
    }

    @Test
    public void canGetBasket() throws Exception {
        ArrayList<Item> basket = checkout.getBasket();
        String firstItemName = basket.get(0).getName();
        assertEquals("Felix", firstItemName);
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
        Item phone = new Item("Iphone", 100, false);
        customer.addItem(phone);
        assertEquals(90, checkout.chargeCustomer(), 0.1);
    }

    @Test
    public void canCheckLoyaltyCard_True() throws Exception {
        customer.aquireLoyaltyCard();
        assertEquals(true, checkout.customerHasLoyaltyCard());
    }

    @Test
    public void canCheckLoyaltyCard_False() throws Exception {
        assertEquals(false, checkout.customerHasLoyaltyCard());
    }

    @Test
    public void applyLoyaltyDiscount() throws Exception {
        customer.aquireLoyaltyCard();
        assertEquals(7.84, checkout.chargeCustomer(), 0.01);
    }

    @Test
    public void appliesLoyaltyDiscountAfter10PercentDiscount() throws Exception {
        customer.emptyBasket();
        customer.aquireLoyaltyCard();
        Item wine = new Item("Red Wine", 40, false);
        customer.addItem(wine);
        assertEquals(35.28, checkout.chargeCustomer(), 0.01);
    }

    @Test
    public void canGetBogofItems() throws Exception {
        ArrayList<Item> basket = customer.getItems();
        ArrayList<Item> bogof = checkout.getBOGOFItems(basket);
        assertEquals(1, bogof.size());
    }

    @Test
    public void canGetNonBogofItems() throws Exception {
        ArrayList<Item> basket = customer.getItems();
        ArrayList<Item> nonBogof = checkout.getNotOnBogof(basket);
        assertEquals(1, nonBogof.size());
    }

    @Test
    public void canCountSameItems() throws Exception {
        ArrayList<Item> basket = checkout.getBasket();
        basket.add(catFood);
        basket.add(catFood);
        assertEquals(3, checkout.countSameItems(catFood, basket));
        assertEquals(1, checkout.countSameItems(tablets, basket));
        assertEquals(4, basket.size());
    }

    @Test
    public void applyBogofEven_2() throws Exception {
        ArrayList<Item> bogof = new ArrayList<>();
        bogof.add(catFood);
        bogof.add(catFood);
        checkout.scanAllItems(bogof);
        assertEquals(5.5, till.getCurrentSaleTotal(), 0.1);
    }

    @Test
    public void applyBogofEven_4() throws Exception {
        ArrayList<Item> bogof = new ArrayList<>();
        bogof.add(catFood);
        bogof.add(catFood);
        bogof.add(catFood);
        bogof.add(catFood);
        checkout.scanAllItems(bogof);
        assertEquals(11, till.getCurrentSaleTotal(), 0.1);
    }

    @Test
    public void applyBogofOdd_3() throws Exception {
        ArrayList<Item> bogof = new ArrayList<>();
        bogof.add(catFood);
        bogof.add(catFood);
        bogof.add(catFood);
        checkout.scanAllItems(bogof);
        assertEquals(11, till.getCurrentSaleTotal(), 0.1);
    }

    @Test
    public void applyBogofOdd_5() throws Exception {
        ArrayList<Item> bogof = new ArrayList<>();
        bogof.add(catFood);
        bogof.add(catFood);
        bogof.add(catFood);
        bogof.add(catFood);
        bogof.add(catFood);
        checkout.scanAllItems(bogof);
        assertEquals(16.5, till.getCurrentSaleTotal(), 0.1);
    }

    @Test
    public void ignoresBogofIfNotOnOffer_Even() throws Exception {
        ArrayList<Item> items = new ArrayList<>();
        items.add(tablets);
        items.add(tablets);
        checkout.scanAllItems(items);
        assertEquals(5.0, till.getCurrentSaleTotal(), 0.1);
    }

    @Test
    public void ignoresBogofIfNotOnOffer_Odd() throws Exception {
        ArrayList<Item> items = new ArrayList<>();
        items.add(tablets);
        items.add(tablets);
        items.add(tablets);
        checkout.scanAllItems(items);
        assertEquals(7.5, till.getCurrentSaleTotal(), 0.1);
    }

    @Test
    public void bogofMixed() throws Exception {
        ArrayList<Item> items = new ArrayList<>();
        items.add(tablets);
        items.add(tablets);
        items.add(tablets);
        items.add(catFood);
        items.add(catFood);
        checkout.scanAllItems(items);
        assertEquals(13, till.getCurrentSaleTotal(), 0.1);
    }

        @Test
    public void canChargeAllDiscounts() throws Exception {
        Item bread = new Item("Bread", 2.0, true);
        Item TV = new Item("Television", 300, false);
        customer.aquireLoyaltyCard();
        customer.emptyBasket();
        customer.addItem(bread);
        customer.addItem(bread);
        customer.addItem(TV);

        double actual = checkout.chargeCustomer();

        assertEquals(266.36, actual, 0.01);

    }
}