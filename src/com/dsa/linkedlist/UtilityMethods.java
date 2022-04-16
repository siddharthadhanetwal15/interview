package com.dsa.linkedlist;

/**
 * Created by dhanetwa on 6/29/2018.
 */
public class UtilityMethods {
    static void pushElement(int data, ListNode head) {
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

    static void print(ListNode head) {
        ListNode traverseNode = head;
        while (traverseNode != null) {
            System.out.println(traverseNode.getData());
            traverseNode = traverseNode.getNext();
        }
    }
}
