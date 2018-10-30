package com.java8.interfacefeature;

/**
 * Created by dhanetwa on 7/11/2018.
 */
public class ImplementingClass implements InterfaceB {

    /*@Override
    public void fun() {
        System.out.println("funI");
    }*/

    public static void main(String[] args) {
        InterfaceB b = new ImplementingClass();
        b.fun();
    }
}
