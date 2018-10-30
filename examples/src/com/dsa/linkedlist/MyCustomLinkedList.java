package com.dsa.linkedlist;

/**
 * Created by dhanetwa on 9/26/2018.
 */
public class MyCustomLinkedList {
    private ListNode head = null;

    void addData(int data){
        ListNode listNode = new ListNode(data);
        if(head == null){
            head = listNode;
            return;
        } else{
            ListNode lastNode = head;
            while (lastNode.getNext() != null){
                lastNode = lastNode.getNext();
            }
            lastNode.setNext(listNode);
        }
    }

    void traverse(){
        ListNode traverseNode = head;
        while (traverseNode != null){
            System.out.println(traverseNode.getData());
            traverseNode = traverseNode.getNext();
        }
    }

    public static void main(String[] args) {
        MyCustomLinkedList myCustomLinkedList = new MyCustomLinkedList();
        myCustomLinkedList.addData(2);
        myCustomLinkedList.addData(4);
        myCustomLinkedList.addData(8);
        myCustomLinkedList.traverse();
    }
}
