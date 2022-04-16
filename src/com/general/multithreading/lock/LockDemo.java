package com.general.multithreading.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dhanetwa on 8/29/2018.
 */
public class LockDemo {
    public static void main(String[] args) {
        final Counter counter = new Counter(new ReentrantLock());
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " " + counter.getCount());
            }
        };
        Thread t1 = new Thread(r, "t1");
        Thread t2 = new Thread(r, "t2");
        Thread t3 = new Thread(r, "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Counter {
    private Lock lock;
    private int count;

    Counter(Lock lock) {
        this.lock = lock;
    }

    public int getCount() {
        lock.lock();
        try {
            count++;
            return count;
        } finally {
            lock.unlock();
        }
    }

    public void setCount(int count) {
        this.count = count;
    }
}
