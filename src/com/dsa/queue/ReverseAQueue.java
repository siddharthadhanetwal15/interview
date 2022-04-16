package com.dsa.queue;

import java.util.Stack;

/**
 * Created by dhanetwa on 7/4/2018.
 */
public class ReverseAQueue {
    void reverseUsingStack(QueueUsingCircularArray queueUsingCircularArray) {
        Stack<Integer> stack = new Stack();
        while (!queueUsingCircularArray.isEmpty(queueUsingCircularArray)) {
            stack.push(queueUsingCircularArray.dequeue());
        }
        while (!stack.isEmpty()) {
            queueUsingCircularArray.enqueue(stack.pop());
        }
    }

    void print(QueueUsingCircularArray queueUsingCircularArray) {
        int i = 0;
        while (i < queueUsingCircularArray.array.length) {
            System.out.println(queueUsingCircularArray.array[i]);
            i++;
        }
    }

    public static void main(String[] args) {
        QueueUsingCircularArray queueUsingCircularArray = new QueueUsingCircularArray(5);
        queueUsingCircularArray.enqueue(5);
        queueUsingCircularArray.enqueue(10);
        queueUsingCircularArray.enqueue(15);
        queueUsingCircularArray.enqueue(20);
        queueUsingCircularArray.enqueue(25);
        ReverseAQueue reverseAQueue = new ReverseAQueue();
        System.out.println("before..");
        reverseAQueue.print(queueUsingCircularArray);
        reverseAQueue.reverseUsingStack(queueUsingCircularArray);
        System.out.println("after..");
        reverseAQueue.print(queueUsingCircularArray);
    }
}
