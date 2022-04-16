package com.dsa.queue;

import com.dsa.linkedlist.ListNode;

/**
 * Created by dhanetwa on 7/3/2018.
 */
public class QueueUsingLinkedList {
    ListNode head;
    int front = 0;
    int rear = 0;

    void insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode traverseNode = head;
            while (traverseNode.getNext() != null) {
                traverseNode = traverseNode.getNext();
            }
            traverseNode.setNext(newNode);
            rear++;
        }
    }

    void deque() {
        head = head.getNext();
        front++;
    }

    void printQueue() {
        ListNode traverseNode = head;
        while (traverseNode != null) {
            System.out.println(traverseNode.getData());
            traverseNode = traverseNode.getNext();
        }
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queueUsingLinkedList = new QueueUsingLinkedList();
        queueUsingLinkedList.insertAtEnd(10);
        queueUsingLinkedList.insertAtEnd(20);
        queueUsingLinkedList.insertAtEnd(30);
        queueUsingLinkedList.insertAtEnd(40);
        queueUsingLinkedList.deque();
        queueUsingLinkedList.deque();
        queueUsingLinkedList.insertAtEnd(50);
        queueUsingLinkedList.deque();
        queueUsingLinkedList.printQueue();
    }
}
