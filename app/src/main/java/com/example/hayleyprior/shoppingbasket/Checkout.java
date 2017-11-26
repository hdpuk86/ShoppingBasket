package com.example.hayleyprior.shoppingbasket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

    public ArrayList<Item> getBasket() {
        return customer.getItems();
    }

    public int countSameItems(Item item, ArrayList<Item> items){
        return Collections.frequency(items, item);
    }

    public HashMap<Item, Integer> countAllItems(ArrayList<Item> items){
        HashMap<Item, Integer > counter = new HashMap<>();
        for(Item item : items){
            Integer count = counter.get(item);
            if (count == null) {
                count = 0;
            }
            counter.put(item, count + 1);
        }
        return counter;
    }

    public void scanAllItems(ArrayList<Item> basket){
        double total = 0;
        ArrayList<Item> onOffer = getBOGOFItems(basket);
        ArrayList<Item> notOnOffer = getNotOnBogof(basket);
        for(Item item : notOnOffer){
            total += item.getPrice();
        }
        total += bogof(onOffer);
        this.till.setCurrentSaleTotal(total);
    }

    public double bogof(ArrayList<Item> bogofItems){
        double total = 0;
        HashMap<Item, Integer> counter = countAllItems(bogofItems);
        Iterator iterator = counter.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry me = (Map.Entry) iterator.next();
            Item item = (Item) me.getKey();
            Integer count = (Integer) me.getValue();
            if(count % 2 == 0){
                total += till.bogofDiscountEven(item, count);
            } else {
                total += till.bogofDiscountOdd(item, count);
            }
        }
        return total;
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

    public ArrayList<Item> getBOGOFItems(ArrayList<Item> items) {
        ArrayList<Item> bogof = new ArrayList<>();
        for(Item item : items){
            if(item.getOnBOGOF()){
                bogof.add(item);
            }
        }
        return bogof;
    }

    public ArrayList<Item> getNotOnBogof(ArrayList<Item> basket){
        ArrayList<Item> notOnOffer = new ArrayList<>();
        for(Item item : basket){
            if(!item.getOnBOGOF()){
                notOnOffer.add(item);
            }
        }
        return notOnOffer;
    }

}
