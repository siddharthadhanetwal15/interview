package com.general.multithreading.producerconsumer;

import java.util.LinkedList;

/**
 * Created by dhanetwa on 4/21/2018.
 */
public class ProducerConsumerExample {
    public static void main(String[] args) {
        final PC pc = new PC();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

        try {
            // t1 finishes before t2
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class PC {
        // Create a list shared by producer and consumer
        // Size of list is 2.
        LinkedList<Integer> linkedList = new LinkedList<>();
        int capacity = 2;

        public void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {
                    // producer thread waits while list is full
                    while (linkedList.size() == capacity)
                        wait();
                    System.out.println("Producer produced-"
                            + value);
                    // to insert the jobs in the list
                    linkedList.add(value++);
                    // notifies the consumer thread that
                    // now it can start consuming
                    notify();
                    // makes the working of program easier
                    // to  understand
                    Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    // consumer thread waits while list is empty
                    while (linkedList.size() == 0)
                        wait();
                    //to retrive the ifrst job in the list
                    int val = linkedList.removeFirst();
                    System.out.println("Consumer consumed-"
                            + val);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
    }
}
