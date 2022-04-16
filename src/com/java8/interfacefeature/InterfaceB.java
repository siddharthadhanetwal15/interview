package com.java8.interfacefeature;

/**
 * Created by dhanetwa on 7/11/2018.
 */
public interface InterfaceB {
    default void fun() {
        System.out.println("funB");
    }
}
