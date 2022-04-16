package com.StringAlgorithms;

/**
 * Created by dhanetwa on 8/8/2018.
 */
public class AddFractions {
    public static void main(String[] args) {
        int num1 = 1;
        int den1 = 500;
        int num2 = 2;
        int den2 = 1500;

        int diff = den2 / den1;
        den1 = den1 * diff;
        num1 = num1 * diff;
        int num3 = num1 + num2;

        int den3 = den2 / diff;
        num3 = num3 / den3;
        System.out.println(num3 + "/" + den3);
    }
}
