package com.general.multithreading.basic;

/**
 * Created by dhanetwa on 4/21/2018.
 */
public class JoinDemo extends Thread{
    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            try{
                Thread.sleep(500);
            }catch(Exception e){System.out.println(e);}
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        JoinDemo joinDemo = new JoinDemo();
        JoinDemo joinDemo2 = new JoinDemo();
        JoinDemo joinDemo3 = new JoinDemo();
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
