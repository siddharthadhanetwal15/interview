package com.general.generic;

/**
 * Created by dhanetwa on 4/19/2018.
 */
public class GenericFunc {
    <T> T genericDisplay(T element){
        return element;
    }
    public static void main(String[] args) {
        GenericFunc genericFunc = new GenericFunc();
        System.out.println(genericFunc.genericDisplay(20));
        System.out.println(genericFunc.genericDisplay("This is string"));
        System.out.println(genericFunc.genericDisplay(14.233));
    }
}
