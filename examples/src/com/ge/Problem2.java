package com.ge;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    /*
    CSV : MNACDSD, ACDFDMN, DPACDMNS
     */
    public static void main(String[] args) {
        String arr[] = {"MNACDSD", "ACDFDMN"};
        char arr1[] = arr[0].toCharArray();
        char arr2[] = arr[1].toCharArray();

        Map<String, Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2.length; j++){
                if (arr[i] == arr[j]) {
                    stringBuilder.append(i);
                }
            }
        }
    }
}
