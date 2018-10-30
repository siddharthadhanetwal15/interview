package com.general.InnerClasses.anonymous.anonymousthatimplementsinterface;

/**
 * Created by dhanetwa on 4/20/2018.
 */
public class MyThread {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("this is inside runnable thread");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Main thread");
        MyThread myThread = new MyThread();
    }
}

