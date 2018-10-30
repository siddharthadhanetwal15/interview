package com.designpatterns.strategy;

public class TestClient {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Item item1 = new Item("1", 250);
        Item item2 = new Item("2", 450);
        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);
        shoppingCart.pay(new DebitCardStrategy("2332 2233 5334 6743", "423"));
        shoppingCart.pay(new PaypalStrategy("sid@gmail.com", "pas123"));

        try {
            System.out.println("in try");
            return;
        } catch (Exception e){

        }finally {
            System.out.println(" finally");
        }
    }

}
