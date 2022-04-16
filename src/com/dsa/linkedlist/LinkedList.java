package com.dsa.linkedlist;

/**
 * Created by dhanetwa on 6/26/2018.
 */
public class LinkedList {
    private int length;
    private ListNode head;

    public LinkedList() {
        length = 0;
    }

    public synchronized ListNode getHead() {
        return head;
    }

    public synchronized void insertAtBegin(ListNode listNode) {
        listNode.setNext(head); //head is nothing but the initial node. we set listnode.next(head) so that when we insert second element, first element which is head should be appended to first element.
        head = listNode; // here after appending, now head is the second node.. which was recently got introduced. head->listNode1->listNode2->null
        length++;
    }

    public synchronized void insertAtEnd(ListNode listNode) {
        if (head == null) {
            head = listNode;
            return;
        }
        ListNode lastNode = head;
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }
        lastNode.setNext(listNode);
        length++;
    }

    private void print() {
        ListNode traverseNode = head;
        while (traverseNode != null) {
            System.out.println(traverseNode.getData());
            traverseNode = traverseNode.getNext();
        }
    }

    public void insertAtPosition(ListNode listNode, int position) {
        if (head == null) {
            System.out.println("linked list empty");
            return;
        }
        int counter = 1;
        ListNode traverseNode = head;
        while (true) {
            if (counter == position) {
                listNode.setNext(traverseNode.getNext());
                traverseNode.setNext(listNode);
                length++;
                break;
            }
            traverseNode = traverseNode.getNext();
            counter++;
        }
    }

    public void insertAtPosition(int data, int position) {
        if (position < 0 || position > length) {
            System.out.println("wrong position");
            return;
        }
        ListNode traverseNode = head;
        int counter = 1;
        position--;
        while (traverseNode != null) {
            if (counter == position) {
                ListNode newListNode = new ListNode(data);
                newListNode.setNext(traverseNode.getNext());
                traverseNode.setNext(newListNode);
                break;
            }
            traverseNode = traverseNode.getNext();
            counter++;
        }
        length++;
    }

    public synchronized void removeFromBegin() {
        ListNode node = head;
        if (node != null) {
            head = node.getNext();
            node.setNext(null);
            length--;
        }
    }

    public synchronized void removeFromEnd() {
        ListNode TNode = head, pTNode = null, next = head.getNext();
        if (head == null) {
            System.out.println("empty list");
        }
        if (next == null) {
            head = null;
        }
        while ((next = TNode.getNext()) != null) {
            pTNode = TNode;
            TNode = next;
        }
        pTNode.setNext(null);
    }

    public void removeFromPosition(int position) {
        ListNode traverseNode = head;
        int counter = 1;
        position--;
        while (traverseNode.getNext() != null) {
            traverseNode = traverseNode.getNext();
            counter++;
            if (counter == position) {
                traverseNode.setNext(traverseNode.getNext().getNext());
                length--;
                break;
            }
        }
    }

    int getPosition(int data) {
        int position = 1;
        ListNode traverseNode = head;
        while (traverseNode.getData() != data) {
            position++;
            traverseNode = traverseNode.getNext();
        }
        return position;
    }

    void clearList(LinkedList linkedList) {
        head = null;
        length = 0;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        ListNode listNode2 = new ListNode(20);
        ListNode listNode1 = new ListNode(10);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(30);
        ListNode listNode5 = new ListNode(25);
        linkedList.insertAtBegin(listNode2);
        linkedList.insertAtBegin(listNode1);
        linkedList.insertAtBegin(listNode3);
        linkedList.insertAtEnd(listNode4);
        linkedList.insertAtPosition(listNode5, 3);
        linkedList.insertAtPosition(15, 3);
        linkedList.removeFromBegin();
        linkedList.removeFromEnd();
        linkedList.removeFromPosition(3);
        linkedList.print();
        System.out.println("position of 25 data : " + linkedList.getPosition(25));
    }
}
