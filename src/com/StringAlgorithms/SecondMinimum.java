package com.StringAlgorithms;

import java.util.Arrays;

/**
 * Created by dhanetwa on 8/8/2018.
 */
public class SecondMinimum {
    public static void main(String[] args) {
        //find second minimum element
        int input[] = {12, 13, 1, 10, 34, 1};
        int first, second, arr_size = input.length;

        /* There should be atleast two elements */
        if (arr_size < 2) {
            System.out.println(" Invalid Input ");
            return;
        }

        first = second = Integer.MAX_VALUE;
        for (int i = 0; i < arr_size; i++) {
            /* If current element is smaller than first
              then update both first and second */
            if (input[i] < first) {
                second = first;
                first = input[i];
            }

            /* If arr[i] is in between first and second
               then update second  */
            else if (input[i] < second && input[i] != first)
                second = input[i];
        }
    }
}
