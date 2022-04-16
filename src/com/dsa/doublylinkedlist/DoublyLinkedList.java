package com.dsa.doublylinkedlist;

/**
 * Created by dhanetwa on 6/27/2018.
 */
public class DoublyLinkedList {
    private int length;
    private DLLNode head;

    public DoublyLinkedList(int data) {
        DLLNode newNode = new DLLNode(data);
        newNode.setPrev(null);
        newNode.setNext(null);
        head = newNode; //important
        length = 1;
    }

    //  head -> 2 -> 5 -> 10
    //            <-   <-
    public void insertAtBegin(int data) {
        DLLNode newNode = new DLLNode(data);
        DLLNode lastNode = head;
        head = newNode;
        newNode.setNext(lastNode);
        lastNode.setPrev(newNode);
       /* 1. allocate node
    * 2. put in the data
        DLLNode new_Node = new DLLNode(data);

    /* 3. Make next of new node as head and previous as NULL
        new_Node.next = head;
        new_Node.prev = null;

    /* 4. change prev of head node to new node
        if (head != null)
            head.prev = new_Node;

    /* 5. move the head to point to the new node
        head = new_Node;*/
    }

    void insertAtEnd(int data) {
        DLLNode newNode = new DLLNode(data);
        DLLNode traverseNode = head;
        while (traverseNode.getNext() != null) {
            traverseNode = traverseNode.getNext();
        }
        traverseNode.setNext(newNode);
        newNode.setPrev(traverseNode);
    }

    void insertAtPosition(int data, int position) {
        int counter = 1;
        DLLNode newNode = new DLLNode(data);
        DLLNode traverseNode = head;
        position--;
        while (counter < position) {
            traverseNode = traverseNode.getNext();
            counter++;
        }
        newNode.setNext(traverseNode.getNext());
        traverseNode.getNext().setPrev(newNode);
        traverseNode.setNext(newNode);
        newNode.setPrev(traverseNode);
    }

    void deleteAtBeginning() {
        DLLNode firstNode = head;
        head = firstNode.getNext();
    }

    void deleteFromEnd() {
        DLLNode traverseNode = head;
        while (traverseNode.getNext() != null) {
            traverseNode = traverseNode.getNext();
        }
        traverseNode.getPrev().setNext(null);
    }

    void deleteFromPosition(int position) {
        int counter = 1;
        position--;
        DLLNode traverseNode = head;
        while (counter < position) {
            traverseNode = traverseNode.getNext();
            counter++;
        }
        traverseNode.setNext(traverseNode.getNext().getNext());
        traverseNode.getNext().setPrev(traverseNode);
    }

    void print() {
        DLLNode traverseNode = head;
        while (traverseNode != null) {
            System.out.println(traverseNode.getData());
            traverseNode = traverseNode.getNext();
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(10);
        doublyLinkedList.insertAtBegin(5);
        doublyLinkedList.insertAtBegin(2);
        doublyLinkedList.insertAtEnd(20);
        doublyLinkedList.insertAtPosition(15, 4);
        doublyLinkedList.deleteAtBeginning();
        doublyLinkedList.deleteFromEnd();
        doublyLinkedList.deleteFromPosition(2);
        doublyLinkedList.print();
    }
}
