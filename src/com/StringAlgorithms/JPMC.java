package com.StringAlgorithms;

/**
 * Created by dhanetwa on 8/30/2018.
 */
public class JPMC {
    public static void main(String[] args) {
        String number = "123";
        char numArray[] = number.toCharArray();
        for (char c:
             numArray) {
            int digit = c - 48;
            //Character.getNumericValue(digit);
            System.out.println(digit);
            //1*100
            //2*20
            //3*1
            // add all
        }
    }
}
