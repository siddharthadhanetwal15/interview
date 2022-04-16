package com.general;

import java.util.*;

/**
 * Created by dhanetwa on 6/20/2018.
 * Given a string that has lowercase letters and numbers, compare the number groupings and print the largest number.
 * Eg: In "gt12cty65mt1" - there are 3 number groupings - 12, 65 and 1. As 65 is the greatest, that is the answer.
 * <p>
 * For this purpose, implement the 'largestNumber' function that takes in a string as an argument and returns the largest number.
 * <p>
 * Input
 * The function takes in a single argument, a string
 * <p>
 * Output
 * Return the largest number of all numeric groupings.
 */
public class puzzleJava {
    public static void main(String[] args) {
        String input = "gt12cty65mt1";
        input = input.replaceAll("[A-z]", " ");
        System.out.println(input);
        StringTokenizer stringTokenizer = new StringTokenizer(input, " ");
        int[] ints = new int[stringTokenizer.countTokens()];
        List<Integer> list = new ArrayList<>();
        while (stringTokenizer.hasMoreElements()) {
            int i = 0;
            list.add(Integer.parseInt(stringTokenizer.nextElement().toString()));
            i++;
        }
        Collections.sort(list);
        int lastIndex = list.size();
        System.out.println("biggest no. : " + list.get(lastIndex - 1));
    }
}
