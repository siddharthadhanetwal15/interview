package com.general.InnerClasses.anonymous.anonymousthatextendsclass;

/**
 * Created by dhanetwa on 4/20/2018.
 */
public class MyThread {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("child thread");
            }
        };
        thread.start();
        System.out.println("main thread");
    }
}
