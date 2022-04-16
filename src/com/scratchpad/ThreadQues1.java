package com.scratchpad;

/**
 * Created by dhanetwa on 9/9/2018.
 */
public class ThreadQues1 {
    public static void main(String[] args) {
        Thread t = new MyThread() {
            public void run() {
                System.out.println("anonymous");
            }
        };
        t.start();
    }

}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("overide run");
    }

    public void run(String a) {
        System.out.println(a);
    }
}