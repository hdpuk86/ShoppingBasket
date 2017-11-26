package com.example.hayleyprior.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hayleyprior on 25/11/2017.
 */

public class TestTill {

    private Till till;

    @Before
    public void setUp() throws Exception {
        till = new Till();
    }

    @Test
    public void canDiscountBy10Percent() throws Exception {
        assertEquals(45, till.discountBy(10, 50), 0.1);
    }

    @Test
    public void canDiscountBy2Percent() throws Exception {
        assertEquals(98, till.discountBy(2, 100), 0.1);
    }

    @Test
    public void canAddToTotal() throws Exception {
        till.addToTotal(10);
        assertEquals(10, till.getCurrentSaleTotal(), 0.1);
    }

    @Test
    public void canSetNewTotal() throws Exception {
        till.addToTotal(3);
        till.setCurrentSaleTotal(50);
        assertEquals(50, till.getCurrentSaleTotal(), 0.1);
    }

    @Test
    public void canApplyBogofDiscountEven_2() throws Exception {
        Item potato = new Item("Potato", 2, true);
        double actual = till.bogofDiscountEven(potato, 2);
        assertEquals(2, actual, 0.1);
    }

    @Test
    public void canApplyBogofDiscountEven_4() throws Exception {
        Item potato = new Item("Potato", 3, true);
        double actual = till.bogofDiscountEven(potato, 4);
        assertEquals(6, actual, 0.1);
    }

    @Test
    public void canApplyBogofDiscountOdd_3() throws Exception {
        Item potato = new Item("Potato", 2, true);
        double actual = till.bogofDiscountOdd(potato, 3);
        assertEquals(4, actual, 0.1);
    }

    @Test
    public void canApplyBogofDiscountOdd_5() throws Exception {
        Item potato = new Item("Potato", 2, true);
        double actual = till.bogofDiscountOdd(potato, 5);
        assertEquals(6, actual, 0.1);
    }
}
