package com.designpatterns.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Item> items;
    public ShoppingCart(){
        this.items = new ArrayList<>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public int getTotal(){
        int sum = 0;
        for(Item item : items){
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentMethod){
        int amount = getTotal();
        paymentMethod.pay(amount);
    }
}
