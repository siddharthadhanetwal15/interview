package com.dsa.stack;

/**
 * Created by dhanetwa on 6/30/2018.
 */
public class StackUsingDynamicArray {
    private int[] stack;
    int top = -1;
    int capacity = 2;

    StackUsingDynamicArray() {
        stack = new int[capacity];
    }

    void push(int data) {
        if (stack.length == top + 1) {
            stack = incrementArrayLength();
        }
        stack[++top] = data;
    }

    void pop() {
        if (top == 0) {
            System.out.println("no item to pop");
        } else {
            stack[top--] = 0;
            stack = decrementArrayLength();
        }
    }

    int getTop() {
        return stack[top];
    }

    void print() {
        for (int i = 0; i < stack.length; i++) {
            System.out.println(stack[i]);
        }
    }

    int[] incrementArrayLength() {
        int temp[] = new int[stack.length * 2];
        System.arraycopy(stack, 0, temp, 0, top + 1);
        return temp;
    }

    int[] decrementArrayLength() {
        int temp[] = new int[stack.length - 1];
        System.arraycopy(stack, 0, temp, 0, top + 1);
        return temp;
    }

    public static void main(String[] args) {
        StackUsingDynamicArray stackUsingDynamicArray = new StackUsingDynamicArray();
        stackUsingDynamicArray.push(10);
        stackUsingDynamicArray.push(20);
        stackUsingDynamicArray.push(30);
        stackUsingDynamicArray.push(40);
        stackUsingDynamicArray.pop();
        stackUsingDynamicArray.push(50);
        stackUsingDynamicArray.pop();
        stackUsingDynamicArray.print();
        System.out.println("top element is: " + stackUsingDynamicArray.getTop());
    }
}
