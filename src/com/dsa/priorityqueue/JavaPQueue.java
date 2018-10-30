package com.dsa.priorityqueue;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by dhanetwa on 9/10/2018.
 */
public class JavaPQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(100);
        priorityQueue.add(5);
        priorityQueue.add(200);
        priorityQueue.add(3);
        priorityQueue.add(1);
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()){
            Integer e = priorityQueue.remove(); // priority queue will remove elements based on natural ordering. insertion will not happen that way(not sorted)
            System.out.println(e);
        }

    }
}
