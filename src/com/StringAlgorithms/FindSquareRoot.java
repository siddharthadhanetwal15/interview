package com.StringAlgorithms;

/**
 * Created by dhanetwa on 8/8/2018.
 */
public class FindSquareRoot {
    public static void main(String[] args) {
        int x = 64;
        if (x == 0 || x == 1) {
            return;
        }
        int i = 1;
        int result = 1;
        while (result <= x) {
            i++;
            result = i * i;
        }
        System.out.println(i - 1);
    }
}
