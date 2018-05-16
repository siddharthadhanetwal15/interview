package com.general.multithreading.callableandfuture;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by dhanetwa on 4/22/2018.
 */
class CallableExample implements Callable{
    @Override
    public Object call() throws Exception {
        Random random = new Random();
        Integer randomNumber = random.nextInt(5);
        // To simulate a heavy computation,
        // we delay the thread for some random time
        Thread.sleep(randomNumber * 1000);

        return randomNumber;
    }
}
public class CallableFutureTaskTest{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // FutureTask is a concrete class that
        // implements both Runnable and Future
        FutureTask[] futureTasks = new FutureTask[5];
        for(int i = 0; i<5; i++){
            Callable callable = new CallableExample();
            // Create the FutureTask with Callable
            futureTasks[i] = new FutureTask(callable);
            // As it implements Runnable, create Thread
            // with FutureTask
            Thread t = new Thread(futureTasks[i]);
            t.start();
        }
        for(int i = 0; i<5; i++){
            // As it implements Future, we can call get()
            System.out.println(futureTasks[i].get());
            // This method blocks till the result is obtained
            // The get method can throw checked exceptions
            // like when it is interrupted. This is the reason
            // for adding the throws clause to main
        }
    }
}
