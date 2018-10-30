package com.dsa.linkedlist;

/**
 * Created by dhanetwa on 6/28/2018.
 */
public class PrintReverse {
    private ListNode head;
    PrintReverse(ListNode head){
        this.head = head;
    }
    java.util.LinkedList s = new java.util.LinkedList();
    void reversePrint(ListNode head){
        if (head == null) return;
        reversePrint(head.getNext());
        s.add(head.getData()); // adding reverse ll to new ll
        System.out.println(head.getData());
    }
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(10);
        ListNode node3 = new ListNode(15);
        ListNode node4 = new ListNode(20);
        ListNode node5 = new ListNode(25);
        ListNode node6 = new ListNode(35);
        ListNode node7 = new ListNode(40);
        ListNode node8 = new ListNode(46);
        linkedList.insertAtBegin(node1);
        linkedList.insertAtEnd(node2);
        linkedList.insertAtEnd(node3);
        linkedList.insertAtEnd(node4);
        linkedList.insertAtEnd(node5);
        linkedList.insertAtEnd(node6);
        linkedList.insertAtEnd(node7);
        linkedList.insertAtEnd(node8);
        PrintReverse printReverse = new PrintReverse(linkedList.getHead());
        printReverse.reversePrint(printReverse.head);
    }
}
