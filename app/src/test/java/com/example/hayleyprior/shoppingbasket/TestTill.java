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
}
