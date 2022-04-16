package com.dsa.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by dhanetwa on 7/4/2018.
 */
public class ImplementStackUsing1Queue {
    Queue<Integer> queue = new LinkedList<>();
    int count = 4;

    void push(int data) {
        queue.add(data);
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }

    void print() {
        System.out.println(queue);
    }
    /*20 10
    30
    20 10 30
    10 30 20
    30 20 10
    40
    30 20 10 40
    20 10 40 30
    10 40 30 20
    40 30 20 10*/

    public static void main(String[] args) {
        ImplementStackUsing1Queue stackUsing1Queue = new ImplementStackUsing1Queue();
        stackUsing1Queue.push(10);
        stackUsing1Queue.push(20);
        stackUsing1Queue.push(30);
        stackUsing1Queue.push(40);
        stackUsing1Queue.print();
    }
}