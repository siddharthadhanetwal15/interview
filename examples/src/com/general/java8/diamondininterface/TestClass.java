package com.general.java8.diamondininterface;
//http://www.lambdafaq.org/what-about-the-diamond-problem/
//https://www.journaldev.com/1775/multiple-inheritance-in-java
//https://www.geeksforgeeks.org/java-and-multiple-inheritance/

public class TestClass implements PT1, PT2 {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.show();
    }

    @Override
    public void show() {
        // use super keyword to call the show
        // method of PI1 interface
        PT1.super.show();

        // use super keyword to call the show
        // method of PI2 interface
        PT2.super.show();
    }
}
