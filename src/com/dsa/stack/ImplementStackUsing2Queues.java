package com.dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dhanetwa on 7/4/2018.
 */
public class ImplementStackUsing2Queues {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    void push(int data) {
        queue1.add(data);
    }
//30 20 10
//20 10
    void pop() {
        Queue<Integer> temp = new LinkedList<>();
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.remove());
            }
            System.out.println("element removed : " + queue1.remove());
            //temp = queue2;
            queue1 = queue2;
            queue2 = temp;
        }
    }

    void print() {
        System.out.println(queue1);
    }

    public static void main(String[] args) {
        ImplementStackUsing2Queues stackUsing2Queues = new ImplementStackUsing2Queues();
        stackUsing2Queues.push(10);
        stackUsing2Queues.push(20);
        stackUsing2Queues.push(30);
        stackUsing2Queues.push(40);
        stackUsing2Queues.pop();
        stackUsing2Queues.print();
        stackUsing2Queues.pop();
        stackUsing2Queues.print();
    }
}
