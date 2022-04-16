package com.test;

import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        byte x = 127;
        x++;

        System.out.print(x);
        System.out.println("sssd".replace("s","d'"));

        Set<String> set = new HashSet<>();
        set.add("Sid");
        set.add("sID");
        set.forEach(System.out::println);
    }
}
