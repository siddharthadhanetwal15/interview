package com.dsa.linkedlist;

/**
 * Created by dhanetwa on 6/28/2018.
 * Find the middle of a given linked list in C and Java
 * Given a singly linked list, find middle of the linked list. For example, if given linked list is 1->2->3->4->5 then output should be 3.
 * <p>
 * If there are even nodes, then there would be two middle nodes, we need to print second middle element. For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
 */
public class MiddleNode {
    private ListNode head;

    public MiddleNode(ListNode head) {
        this.head = head;
    }

    int findMiddlePosition() {
        ListNode traverseNode = head;
        int length = 1;
        while (traverseNode.getNext() != null) {
            traverseNode = traverseNode.getNext();
            length++;
        }
        int middlePosition;
        middlePosition = length / 2 + 1;
        return middlePosition;
    }

    int findElementAtPosition(int position) {
        ListNode traverseNode = head;
        int counter = 1;
        while (counter < position) {
            traverseNode = traverseNode.getNext();
            counter++;
        }
        return traverseNode.getData();
    }

    int efficientApproach() {
        ListNode firstPointer = head;
        ListNode secondPointer = head;
        int toggle = 0;
        while (firstPointer.getNext() != null) {
            if (toggle == 0) {
                firstPointer = firstPointer.getNext();
                toggle = 1;
            } else if (toggle == 1) {
                firstPointer = firstPointer.getNext();
                secondPointer = secondPointer.getNext();
                toggle = 0;
            }
        }
        return secondPointer.getData();
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
        ListNode head = linkedList.getHead();
        MiddleNode middleNode = new MiddleNode(head);
        int pos = middleNode.findMiddlePosition();
        System.out.println(pos);
        System.out.println("middle element of list is: " + middleNode.findElementAtPosition(pos));
        System.out.println("efficient approach for middle element: " + middleNode.efficientApproach());
    }
}
