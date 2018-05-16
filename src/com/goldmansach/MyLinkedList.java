package com.goldmansach;

/**
 * Created by dhanetwa on 11/28/2017.
 */
public class MyLinkedList {
    Node head;  // head of list

    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;

        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(int d) {
            data = d;
        }
    }

    /* This function is in LinkedList class. Inserts a
   new Node at front of the list. This method is
   defined inside LinkedList class shown above */
    public void pushInFront(int new_data)
    {
    /* 1 & 2: Allocate the Node &
              Put in the data*/
        Node new_node = new Node(new_data);

    /* 3. Make next of new Node as head */
        new_node.next = head;

    /* 4. Move the head to point to new Node */
        head = new_node;
    }
    /* This function prints contents of linked list starting from
            the given node */

    /* This function is in LinkedList class.
   Inserts a new node after the given prev_node. This method is
   defined inside LinkedList class shown above */
    public void insertAfter(Node prev_node, int new_data)
    {
    /* 1. Check if the given Node is null */
        if (prev_node == null)
        {
            System.out.println("The given previous node cannot be null");
            return;
        }

    /* 2. Allocate the Node &
       3. Put in the data*/
        Node new_node = new Node(new_data);

    /* 4. Make next of new Node as next of prev_node */
        new_node.next = prev_node.next;

    /* 5. make next of prev_node as new_node */
        prev_node.next = new_node;
    }

    public void printList()
    {
        Node tnode = head;
        System.out.print("Items in Linked List : ");
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.pushInFront(10);
        myLinkedList.pushInFront(20);
        myLinkedList.pushInFront(30);
        myLinkedList.insertAfter(myLinkedList.head,25); // this is the keypoint where we are pointing to the node where we have to point(previous node)
        myLinkedList.printList();

    }
}
