package com.general.multithreading.evenoddprint;

class Printer{
    int counter = 0;
    void even() throws InterruptedException {
        synchronized (this){
            while(counter != 20){
                if(counter % 2 == 1){
                    wait();
                } else{
                    notify();
                    System.out.println(Thread.currentThread().getName() + " : " + counter++);
                }
            }
        }
    }
    void odd() throws InterruptedException {
        synchronized (this){
            while (counter != 20){
                if(counter % 2 == 0){
                    wait();
                } else{
                    notify();
                    System.out.println(Thread.currentThread().getName() + " : " + counter++);
                }
            }
        }
    }
}
public class PrintEvenOddUsingTwoThreads {
    public static void main(String[] args) {
        final Printer printer = new Printer();
        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printer.even();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printer.odd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        evenThread.setName("Even Thread");
        oddThread.setName("Odd Thread");
        evenThread.start();
        oddThread.start();
    }
}
