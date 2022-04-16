package com.dsa.stack;

import com.dsa.linkedlist.ListNode;

/**
 * Created by dhanetwa on 6/30/2018.
 */
public class StackUsingLinkedList {
    ListNode top;

    void push(int data) {
        ListNode newNode = new ListNode(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
    }

    void pop() {
        top = top.getNext();
    }

    void print() {
        ListNode traverseNode = top;
        while (traverseNode != null) {
            System.out.println(traverseNode.getData());
            traverseNode = traverseNode.getNext();
        }
    }

    public static void main(String[] args) {
        StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList();
        stackUsingLinkedList.push(30);
        stackUsingLinkedList.push(25);
        stackUsingLinkedList.push(15);
        stackUsingLinkedList.push(8);
        stackUsingLinkedList.pop(); // which inserted in last hat will go out first.
        stackUsingLinkedList.print();
    }
}
