package com.general.multithreading.basic;

/**
 * Created by dhanetwa on 4/21/2018.
 */
public class JoinDemo extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(this.getName() + " : " + i);
        }
    }

    public static void main(String[] args) {
        JoinDemo joinDemo = new JoinDemo();
        joinDemo.setName("Thread 1");
        JoinDemo joinDemo2 = new JoinDemo();
        joinDemo2.setName("Thread 2");
        JoinDemo joinDemo3 = new JoinDemo();
        joinDemo3.setName("Thread 3");
        joinDemo.start();
        try {
            joinDemo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        joinDemo2.start();
        joinDemo3.start();
    }
}
