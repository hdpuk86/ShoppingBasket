package com.example.hayleyprior.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        customer = new Customer(basket, false);
    }

    @Test
    public void canAddItem() throws Exception {
        customer.addItem(cheese);
        assertEquals(1, basket.countItems());
    }

    @Test
    public void canRemoveItem() throws Exception {
        customer.addItem(cheese);
        customer.addItem(sandwich);
        customer.removeItem(cheese);
        assertEquals(1, basket.countItems());
    }

    @Test
    public void itemRemovedIsCorrectItem() throws Exception {
        customer.addItem(cheese);
        customer.addItem(sandwich);
        customer.removeItem(cheese);
        String itemInBasket = basket.getItems().get(0).getName();
        assertEquals("Tuna Mayo Sub", itemInBasket);
    }

    @Test
    public void canEmptyBasket() throws Exception {
        customer.addItem(cheese);
        customer.addItem(sandwich);
        customer.emptyBasket();
        assertEquals(0, basket.countItems());
    }

    @Test
    public void canGetBasket() throws Exception {
        customer.addItem(cheese);
        customer.addItem(sandwich);
        ArrayList<Item> items = customer.getItems();
        assertEquals(2, items.size());
    }

    @Test
    public void canAquireLoyaltyCard() throws Exception {
        customer.aquireLoyaltyCard();
        assertEquals(true, customer.hasLoyaltyCard());
    }

    @Test
    public void canLoseLoyaltyCard() throws Exception {
        customer.aquireLoyaltyCard();
        customer.loseLoyaltyCard();
        assertEquals(false, customer.hasLoyaltyCard());
    }
}
