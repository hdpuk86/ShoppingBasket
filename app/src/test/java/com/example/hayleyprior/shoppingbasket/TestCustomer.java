package com.example.hayleyprior.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by hayleyprior on 25/11/2017.
 */

public class TestCustomer {

    private Item cheese;
    private Item sandwich;
    private Basket basket;
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        sandwich = new Item("Tuna Mayo Sub", 1.8, Category.FOODTOGO, true);
        cheese = new Item("Cheddar", 2.4, Category.DAIRY, false);
        basket = new Basket();
        customer = new Customer(false);
    }

    @Test
    public void canAddItem() throws Exception {
        customer.addItem(basket, cheese);
        assertEquals(1, basket.countItems());
    }

    @Test
    public void canRemoveItem() throws Exception {
        customer.addItem(basket, cheese);
        customer.addItem(basket, sandwich);
        customer.removeItem(basket, cheese);
        assertEquals(1, basket.countItems());
    }

    @Test
    public void itemRemovedIsCorrectItem() throws Exception {
        customer.addItem(basket, cheese);
        customer.addItem(basket, sandwich);
        customer.removeItem(basket, cheese);
        String itemInBasket = basket.getItems().get(0).getName();
        assertEquals("Tuna Mayo Sub", itemInBasket);
    }

    @Test
    public void canEmptyBasket() throws Exception {
        customer.addItem(basket, cheese);
        customer.addItem(basket, sandwich);
        customer.emptyBasket(basket);
        assertEquals(0, basket.countItems());
    }

    @Test
    public void canGetLoyaltyCard() throws Exception {
        customer.getLoyaltyCard();
        assertEquals(true, customer.hasLoyaltyCard());
    }

    @Test
    public void canLoseLoyaltyCard() throws Exception {
        customer.getLoyaltyCard();
        customer.loseLoyaltyCard();
        assertEquals(false, customer.hasLoyaltyCard());
    }
}
