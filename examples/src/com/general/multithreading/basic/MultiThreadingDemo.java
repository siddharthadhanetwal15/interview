package com.general.multithreading.basic;

/**
 * Created by dhanetwa on 4/20/2018.
 */
class MultiThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "is running");
    }
}
class MultiThreadUsingRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("inside runnable");
        System.out.println(Thread.currentThread() + "is running");
    }
}
public class MultiThreadingDemo {

    public static void main(String[] args) {
        for(int i=0; i<8; i++) {
            MultiThread multiThread = new MultiThread();
            multiThread.start();
            Thread t1 = new Thread(new MultiThreadUsingRunnable());
            Thread t2 = new Thread(new Runnable(){
                @Override
                public void run() {
                    System.out.println("hi, thready!!");
                }
            });
            t1.start();
        }
    }
}
