package com.general.multithreading.basic;

import java.util.Scanner;

/**
 * Created by dhanetwa on 4/21/2018.
 */
public class WaitNotifyExample {
    public static void main(String[] args) {
        final PC pc = new PC();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

        try {
            // t1 finishes before t2
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static class PC{
        // Prints a string and waits for consume()
        public void produce() throws InterruptedException {
            synchronized (this){
                System.out.println("producer thread running");
                // releases the lock on shared resource
                wait();
                // and waits till some other method invokes notify().
                System.out.println("Resumed");
            }
        }
        // Sleeps for some time and waits for a key press. After key
        // is pressed, it notifies produce().
        public void consume() throws InterruptedException {
            // this makes the produce thread to run first.
            Thread.sleep(1000);
            Scanner s = new Scanner(System.in);
            synchronized (this){
                System.out.println("Waiting for return key.");
                s.nextLine();
                System.out.println("Return key pressed");
                // notifies the produce thread that it
                // can wake up.
                notify();
                Thread.sleep(2000);
            }
        }
    }
}
