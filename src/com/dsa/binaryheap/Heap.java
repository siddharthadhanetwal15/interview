package com.dsa.binaryheap;


/**
 * Created by dhanetwa on 9/10/2018.
 */
public class Heap {
    public int[] array;
    public int count;
    public int capacity;
    public int heap_type;

    public Heap(int capacity, int heap_type) {
        this.heap_type = heap_type;
        this.count = 0;
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public int parent(int capacity, int heap_type) {
        return 0;
    }

    public int leftChild(int i) {
        return 0;
    }

    public int rightChild(int i) {
        return 0;
    }

    public int getMax(int i) {
        return 0;
    }

}
