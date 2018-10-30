package com.dsa.linkedlist;

import java.util.Hashtable;

/**
 * Created by dhanetwa on 6/28/2018.
 */
public class LLAccessUsingHashTable {
    ListNode head;
    Hashtable<Integer, Integer> hashtable = new Hashtable<>();
    int position = 1;

    void pushElement(int data){
        ListNode newNode = new ListNode(data);
        ListNode traverseNode = head;
        if(traverseNode == null){
            traverseNode = newNode;
            head = traverseNode;
        } else{
            while(traverseNode.getNext() != null){
                traverseNode = traverseNode.getNext();
            }
            traverseNode.setNext(newNode);
            position++;
        }
        hashtable.put(position, traverseNode.getData());
    }

    public static void main(String[] args) {
        LLAccessUsingHashTable llAccessUsingHashTable = new LLAccessUsingHashTable();
        llAccessUsingHashTable.pushElement(5);
        llAccessUsingHashTable.pushElement(10);
        llAccessUsingHashTable.pushElement(15);
        llAccessUsingHashTable.pushElement(20);
        llAccessUsingHashTable.pushElement(25);
        System.out.println(llAccessUsingHashTable.hashtable.get(3));
    }
}
