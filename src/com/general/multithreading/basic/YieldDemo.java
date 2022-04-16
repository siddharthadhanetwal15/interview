package com.general.multithreading.basic;

/**
 * Created by dhanetwa on 4/21/2018.
 */
public class YieldDemo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++)
            System.out.println(Thread.currentThread().getName()
                    + " in control");
    }

    public static void main(String[] args) {
        YieldDemo yieldDemo = new YieldDemo();
        yieldDemo.setName("child thread");
        yieldDemo.setPriority(8);
        yieldDemo.start();
        for (int i = 0; i < 5; i++) {
            // Control passes to child thread
            //wo usko dega.. fir wo isko dega.. esa chalta rahega.. surrender
            Thread.yield();

            // After execution of child Thread
            // main thread takes over
            System.out.println(Thread.currentThread().getName()
                    + " in control");
        }
    }
}
