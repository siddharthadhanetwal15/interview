package com.general.multithreading.callableandfuture;

import java.util.Random;

/**
 * Created by dhanetwa on 4/22/2018.
 */
public class RunnableFutureTaskTest {
    public static void main(String[] args) throws InterruptedException {
        RunnableExample[] runnableExamples = new RunnableExample[5];
        for (int i = 0; i < 5; i++) {
            runnableExamples[i] = new RunnableExample();
            Thread t = new Thread(runnableExamples[i]);
            t.start();
        }
        for (int i = 0; i < 5; i++)
            System.out.println(runnableExamples[i].get());
    }
}

class RunnableExample implements Runnable {
    // Shared object to store result
    private Object result = null;

    @Override
    public void run() {
        Random generator = new Random();
        Integer randomNumber = generator.nextInt(5);
        // As run cannot throw any Exception
        try {
            Thread.sleep(randomNumber * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Store the return value in result when done
        result = randomNumber;
        synchronized (this) {
            notify();
        }
    }

    public synchronized Object get()
            throws InterruptedException {
        while (result == null)
            wait();

        return result;
    }

}