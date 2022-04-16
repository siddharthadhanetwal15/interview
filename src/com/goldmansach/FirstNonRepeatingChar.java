package com.goldmansach;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dhanetwa on 11/18/2017.
 */
public class FirstNonRepeatingChar {
    /*Given a string, find the first non-repeating character in it. For example,
    if the input string is “GeeksforGeeks”, then output should be ‘f’ and if input
    string is “GeeksQuiz”, then output should be ‘G’.*/
    static void usingHashMap() {
        String input = "Geekszzzzzzzzzzzzzzzzzzzzzzzzzzzzzz33333331sforGeeks";
        char[] charArray = input.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < charArray.length; i++) {
            if (hashMap.containsKey(charArray[i])) {
                hashMap.put(charArray[i], hashMap.get(charArray[i]) + 1);
            } else {
                hashMap.put(charArray[i], 1);
            }
        }
        for (int i = 0; i < charArray.length; i++) {
            if (hashMap.get(charArray[i]) == 1) {
                System.out.println(charArray[i]);
                break;
            }
        }
    }

    public static void main(String[] args) {
        //MySol. o(n2)
        String input = "GeeksforGeeks";
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int count = 0;
            for (int j = 0; j < charArray.length; j++) {
                if (charArray[i] == charArray[j]) {
                    count = count + 1;
                }
            }
            if (count == 1) {
                System.out.println(charArray[i]);
                break;
            }
        }
        usingHashMap();
    }
}
