package com.scratchpad;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dhanetwa on 9/7/2018.
 */
public class ItemSort {
    public static void main(String[] args) {
        Item item1 = new Item("soap", 50);
        Item item2 = new Item("deo", 99);
        Item item3 = new Item("toothbrush", 15);

        List<Item> listOfItems = new LinkedList<>();
        listOfItems.add(item1);
        listOfItems.add(item2);
        listOfItems.add(item3);
        System.out.println(listOfItems);
        Collections.sort(listOfItems, new SortByPrice());
        System.out.println(listOfItems);
    }
}

class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class SortByPrice implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return Integer.compare(((Item) o1).getPrice(), ((Item) o2).getPrice());
    }
}
