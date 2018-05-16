package com.general.ExecutorFramework;

/**
 * Created by dhanetwa on 1/28/2018.
 */
public class RunnableThread implements Runnable {
    private int id;
    private int counter;

    public RunnableThread(int id, int counter) {
        this.id = id;
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < counter; i++) {
            try {
                System.out.println("Task ID: " +
                        id + " Iter No: " + i);
                Thread.sleep(1000);
            } catch (Exception ex) {
                System.out.println("Task ID: " +
                        id + " is interrupted.");
                break;
            }
        }
    }
}
