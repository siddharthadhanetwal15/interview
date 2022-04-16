package com.dsa.circularlinkedlist;

/**
 * Created by dhanetwa on 6/28/2018.
 */
public class CircularLinkedList {
    private CLLNode tail;
    private int length = 0;

    public CircularLinkedList(int data) {
        CLLNode newNode = new CLLNode(data);
        tail = newNode;
        tail.setNext(newNode);
    }

    void addInBeginning(int data) {
        CLLNode newNode = new CLLNode(data);
        CLLNode tempList = tail;
        tempList.setNext(newNode);
        newNode.setNext(tempList);
        tail = newNode;
    }

    void insertAtLast(int data) {
        CLLNode newNode = new CLLNode(data);
        CLLNode traverseNode = tail;
        while (traverseNode.getNext() != tail) {
            traverseNode = traverseNode.getNext();
        }
        newNode.setNext(traverseNode.getNext());
        traverseNode.setNext(newNode);
    }

    void insertAtPosition(int data, int position) {
        CLLNode newNode = new CLLNode(data);
        int current = 1;
        position--;
        CLLNode traverseNode = tail;
        while (current < position) {
            traverseNode = traverseNode.getNext();
            current++;
        }
        newNode.setNext(traverseNode.getNext());
        traverseNode.setNext(newNode);
    }

    void deleteFromBeginning() {
        CLLNode traverseNode = tail;
        /*while (traverseNode.getNext() != tail){
            traverseNode = traverseNode.getNext();
        }
        traverseNode.setNext(traverseNode.getNext().getNext());*/
    }

    void print() {
        CLLNode traverseNode = tail;
        System.out.println(traverseNode.getData());
        while (traverseNode.getNext() != tail) {
            traverseNode = traverseNode.getNext();
            System.out.println(traverseNode.getData());
        }
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList(10);
        circularLinkedList.addInBeginning(5);
        circularLinkedList.insertAtLast(20);
        circularLinkedList.insertAtPosition(15, 3);
        circularLinkedList.deleteFromBeginning();
        circularLinkedList.print();
    }
}
