package com.scratchpad;

/**
 * Created by dhanetwa on 9/19/2018.
 */
public class PanagramTest {
    public static void main(String[] args) {
        String testString  = "The quick brown fox jumps over the lazy dogl";
        System.out.println("String is panagram : " + isPanagram(testString));
    }

    static boolean isPanagram(String sentence){
        boolean isPanagram = true;
        sentence = sentence.replaceAll(" ", "");
        char charArray[] = sentence.toCharArray();
        boolean mask[] = new boolean[26];
        int index=0;
        for (char c : charArray){
            if(c >= 'a' && c <= 'z'){
                index = c - 'a';
            }
            mask[index] = true;
        }

        for(int i = 0; i<=25; i++){
            if(mask[i] == false){
                return false;
            }
        }

        return isPanagram;
    }
}
