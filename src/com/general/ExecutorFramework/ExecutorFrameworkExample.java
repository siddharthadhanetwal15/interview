package com.general.ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dhanetwa on 1/28/2018.
 */
public class ExecutorFrameworkExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 3; i++)
            executorService.submit(new RunnableThread(i, 5) {
            });
        executorService.shutdown();
    }
}
