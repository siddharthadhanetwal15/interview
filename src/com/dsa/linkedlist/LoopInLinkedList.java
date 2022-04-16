package com.dsa.linkedlist;

import java.util.Hashtable;

/**
 * Created by dhanetwa on 6/29/2018.
 */
public class LoopInLinkedList {
    ListNode head;

    void pushElement(int data) {
        ListNode newNode = new ListNode(data);
        ListNode traverseNode = head;
        if (head == null) {
            head = newNode;
            return;
        } else {
            while (traverseNode.getNext() != null) {
                traverseNode = traverseNode.getNext();
            }
            traverseNode.setNext(newNode);
        }
    }

    void print() {
        ListNode traverseNode = head;
        while (traverseNode != null) {
            System.out.println(traverseNode.getData());
            traverseNode = traverseNode.getNext();
        }
    }

    void makeLoop() {
        ListNode lastNode = head;
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }
        lastNode.setNext(head.getNext().getNext().getNext());
    }

    void checkLoopUsingTwoPointers() { // floyd cycle
        int data = 0;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                System.out.println("loop found");
                break;
            }
        }
    }

    int checkUsingVisitedVar() {
        ListNode traverseNode = head;
        while (traverseNode.getNext() != null) {
            if (traverseNode.isVisited()) {
                return traverseNode.getData();
            } else {
                traverseNode.setVisited(true);
                traverseNode = traverseNode.getNext();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LoopInLinkedList loopInLinkedList = new LoopInLinkedList();
        loopInLinkedList.pushElement(5);
        loopInLinkedList.pushElement(10);
        loopInLinkedList.pushElement(15);
        loopInLinkedList.pushElement(20);
        loopInLinkedList.pushElement(25);
        loopInLinkedList.pushElement(30);
        loopInLinkedList.pushElement(40);
        loopInLinkedList.pushElement(50); //50 points to 20
        loopInLinkedList.print();
        loopInLinkedList.makeLoop();
        loopInLinkedList.checkLoopUsingTwoPointers();
        System.out.println(loopInLinkedList.checkUsingVisitedVar());
    }
}
