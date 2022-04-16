package com.general.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhanetwa on 2/13/2018.
 */
public class ImmutabilityTest implements Cloneable {
    public static void main(String[] args) {
        String s1 = "Soumya";
        String s2 = "Ranjan";
        s1.concat(s2);
        System.out.println(s1);
        System.out.println(s2);
    }
}
