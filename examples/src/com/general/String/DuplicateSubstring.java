package com.general.String;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by dhanetwa on 7/29/2018.
 */
public class DuplicateSubstring {

    void getSubstring(String inputString, int sequenceLength){
        if (inputString.isEmpty() || sequenceLength <= 0 || sequenceLength >= inputString.length()) {
            System.out.println("Invalid input");
        } else {
            int i = 0;
            int j = i + sequenceLength;
            Set<String> tempSet = new HashSet<>();
            Set<String> repeatingSequences = new TreeSet<>();
            while (j <= inputString.length()) {
                if (!tempSet.add(inputString.substring(i, j))) {
                    repeatingSequences.add(inputString.substring(i, j));
                }
                i++;
                j = i + sequenceLength;
            }
            for (String str : repeatingSequences) {
                System.out.println(str);
            }
        }
    }
}
