package com.general.multithreading.threadpool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by dhanetwa on 4/21/2018.
 * As seen in the execution of the program, the task 4 or task 5 are executed only when a thread in the pool becomes idle.
 * Until then, the extra tasks are placed in a queue.
 */
public class ThreadPoolTest {
    // Maximum number of threads in thread pool
    static final int MAX_T = 3;

    public static void main(String[] args) {
        Runnable r1 = new Task("task1");
        Runnable r2 = new Task("task2");
        Runnable r3 = new Task("task3");
        Runnable r4 = new Task("task4");
        Runnable r5 = new Task("task5");
        // creates a thread pool with MAX_T no. of
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);

        pool.shutdown();
    }
}
class Task implements Runnable{
    private String name;
    public Task(String name){
        this.name = name;
    }
    // Prints task name and sleeps for 1s
    // This Whole process is repeated 5 times
    @Override
    public void run() {
        try{
            for(int i = 0; i<5; i++){
                if (i==0)
                {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Initialization Time for"
                            + " task name - "+ name +" = " +ft.format(d));
                    //prints the initialization time for every task
                }
                else{
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Executing Time for task name - "+
                            name +" = " +ft.format(d));
                    // prints the execution time for every task
                }
                Thread.sleep(1000);
            }
            System.out.println(name+" complete");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
