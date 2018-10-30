package com.designpatterns.strategy;

public class Item {
    private String pcode;
    private int price;

    public Item(String pcode, int price) {
        this.pcode = pcode;
        this.price = price;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
