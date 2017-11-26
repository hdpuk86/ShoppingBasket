package com.example.hayleyprior.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hayleyprior on 25/11/2017.
 */

public class TestBasket {
    private Item apple;
    private Item bread;
    private Basket basket;

    @Before
    public void setUp() throws Exception {
        bread = new Item("Hovis", 1.0, true);
        apple = new Item("Pink Lady", 0.5, false);
        basket = new Basket();
    }

    @Test
    public void basketStartsEmpty() throws Exception {
        assertEquals(0, basket.countItems());
    }

    @Test
    public void canAddItem() throws Exception {
        basket.addItem(bread);
        assertEquals(1, basket.countItems());
    }

    @Test
    public void canAddMultipleItems() throws Exception {
        basket.addItem(bread);
        basket.addItem(apple);
        assertEquals(2, basket.countItems());
    }

    @Test
    public void canRemoveItem() throws Exception {
        basket.addItem(apple);
        basket.addItem(bread);
        basket.removeItem(bread);
        assertEquals(1, basket.countItems());
    }

    @Test
    public void itemRemovedIsCorrectItem() throws Exception {
        basket.addItem(apple);
        basket.addItem(bread);
        basket.removeItem(apple);
        String itemName = basket.getItems().get(0).getName();
        assertEquals("Hovis", itemName);
    }

    @Test
    public void canEmpty() throws Exception {
        basket.addItem(apple);
        basket.addItem(bread);
        basket.empty();
        assertEquals(0, basket.countItems());
    }
}
