package com.general.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by dhanetwa on 4/18/2018.
 */
public class ReverseString {
    public static String method1(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.reverse().toString();
    }

    public static void method2(String str){
        char[] chars = str.toCharArray();
        for(int i = chars.length-1; i>=0; i--){
            System.out.print(chars[i]);
        }
    }

    public static void method3(String str){
        List<Character> characterList = new ArrayList<>();
        for(char c : str.toCharArray()){
            characterList.add(c);
        }
        Collections.reverse(characterList);
        ListIterator listIterator = characterList.listIterator();
        while (listIterator.hasNext()){
            System.out.print(listIterator.next());
        }
    }

    public static void main(String[] args) {
        String stringToReverse = "Hello ji kese ho!!";
        System.out.println(method1(stringToReverse));
        method2(stringToReverse);
        System.out.println();
        method3(stringToReverse);
    }
}
