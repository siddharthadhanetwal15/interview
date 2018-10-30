package com.scratchpad;

/**
 * Created by dhanetwa on 9/8/2018.
 */
public class FinalUse {
    final int a; // can be initialized in constructor or here
    int id;

    public FinalUse(int id) {
        this.id = id;
        a = 10;
    }

    public int getA() {
        //a = 2; CT error
        return a;
    }

    public static void main(String[] args) {
        final FinalUse fuse = new FinalUse(2);
        //fuse = new FinalUse(4);
    }
}
