package com.general;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dhanetwa on 7/12/2018.
 */
public class PanagramChecking {
    void method1() {
        //using map or use hash set. hash set dont allow duplicate
        Map<Character, Integer> map = new HashMap<>();
        String stringToCheck = "the quick brown fox jumps over the lazy dog";
        stringToCheck = stringToCheck.replaceAll(" ", "");
        char[] charArray = stringToCheck.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (map.containsKey(charArray[i])) {
                map.put(charArray[i], map.get(charArray[i]) + 1);
            } else {
                map.put(charArray[i], 1);
            }
        }
        if (map.keySet().size() < 26) {
            System.out.println("not a panagram");
        } else {
            System.out.println("its a panagram!!");
        }
    }

    boolean method2(String stringToCheck) {
        for (char p = 'a'; p <= 'z'; p++) {
            if (stringToCheck.indexOf(p) < 0) {
                return false;
            }
        }
        return true;
    }

    void nonPangramChars(String stringToCheck) {
        for (char p = 'a'; p <= 'z'; p++) {
            if (stringToCheck.indexOf(p) < 0) {
                System.out.print(p);
            }
        }
    }

    public static void main(String[] args) {
        PanagramChecking panagramChecking = new PanagramChecking();
        panagramChecking.method1();
        String stringToCheck = "the quick brown fox jumps over the lazy";
        if (panagramChecking.method2(stringToCheck)) {
            System.out.println("pangram");
        } else {
            System.out.println("not a pangram");
        }
        panagramChecking.nonPangramChars(stringToCheck);
    }
}
