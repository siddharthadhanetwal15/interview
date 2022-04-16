package com.latestjava8;

import java.util.StringJoiner;

public class StringJoinerExample {
    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(",");
        stringJoiner.add("sid");
        stringJoiner.add("junior");
        System.out.println(stringJoiner);

        StringJoiner secondJoiner = new StringJoiner(":");
        secondJoiner.add("had");
        secondJoiner.add("fun");
        System.out.println(stringJoiner.merge(secondJoiner));
    }
}
