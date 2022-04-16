package com.general.multithreading.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by dhanetwa on 4/24/2018.
 */
class Computation1 implements Runnable {
    public static int product = 0;

    @Override
    public void run() {
        product = 2 * 3;
        try {
            Tester.cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class Computation2 implements Runnable {
    public static int sum = 0;

    @Override
    public void run() {
        // check if newBarrier is broken or not
        System.out.println("Is the barrier broken? - " + Tester.cyclicBarrier.isBroken());
        sum = 10 + 20;
        try {
            Tester.cyclicBarrier.await(3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}

public class Tester implements Runnable {
    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args) {
        Tester tester = new Tester();
        Thread t1 = new Thread(tester);
        t1.start();
    }

    @Override
    public void run() {
        System.out.println("Number of parties required to trip the barrier = " +
                cyclicBarrier.getParties());
        System.out.println("Total of product and sum = " + (Computation1.product +
                Computation2.sum));
        // objects on which the child thread has to run
        Computation1 comp1 = new Computation1();
        Computation2 comp2 = new Computation2();
        // creation of child thread
        Thread t1 = new Thread(comp1);
        Thread t2 = new Thread(comp2);
        t1.start();
        t2.start();
        try {
            Tester.cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Number of parties waiting at the barrier at this point = " + cyclicBarrier.getNumberWaiting());
        // barrier breaks as the number of thread waiting for the barrier
        // at this point = 3
        System.out.println("Sum of product and sum = " + (Computation1.product +
                Computation2.sum));
        // Resetting the newBarrier

        cyclicBarrier.reset();
        System.out.println("Barrier reset successful");
    }
}
