package com.dsa.queue;

/**
 * Created by dhanetwa on 7/2/2018.
 */
public class QueueUsingArray {
    int front, rear, size;
    int capacity;
    int queue[];

    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = size = 0;
        rear = -1;
    }

    void enqueue(int data) {
        queue[++rear] = data;
    }

    int dequeue() {
        int frontItem = front();
        queue[front] = 0;
        front = front + 1;
        return frontItem;
    }

    int front() {
        return queue[front];
    }

    int rear() {
        return queue[rear];
    }

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(50);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue() +
                " dequeued from queue\n");

        System.out.println("Front item is " +
                queue.front());

        System.out.println("Rear item is " +
                queue.rear());
    }
}
