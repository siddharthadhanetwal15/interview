package com.scratchpad;

/**
 * Created by dhanetwa on 9/24/2018.
 */
public class ThreadTest2Start extends Thread {
    @Override
    public void run() {
        System.out.println("from inside run");
    }

    public static void main(String[] args) {
        ThreadTest2Start threadTest = new ThreadTest2Start();
        threadTest.start();
        System.out.println("abc");
        threadTest.start(); // illegal state exception
        System.out.println("after first start");
    }
}
