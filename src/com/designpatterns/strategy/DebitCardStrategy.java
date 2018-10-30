package com.designpatterns.strategy;

public class DebitCardStrategy implements PaymentStrategy {
    private String cardNo;
    private String cvv;

    public DebitCardStrategy(String cardNo, String cvv) {
        this.cardNo = cardNo;
        this.cvv = cvv;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid by debit card");
    }
}
