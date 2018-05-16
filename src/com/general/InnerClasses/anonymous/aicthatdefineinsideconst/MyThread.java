package com.general.InnerClasses.anonymous.aicthatdefineinsideconst;

/**
 * Created by dhanetwa on 4/20/2018.
 */
public class MyThread {
    public static void main(String[] args) {
        int x = 10;
        Thread t = new Thread(new Runnable() {
            void abc(){
                System.out.println(x);
            }
            @Override
            public void run() {
                abc();
                System.out.println("inside new thread");
            }
        });
        t.start();
    }
}
