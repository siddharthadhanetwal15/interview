package com.goldmansach;

/**
 * Created by dhanetwa on 11/29/2017.
 */
public class MyStack {
    String[] stack = new String[5];
    int position = 0;

    void push(String element) {
        if (position != 4) {
            stack[position] = element;
            position++;
        }
    }

    void pop() {
        if (position != 0) {
            position--;
            stack[position] = null;
        }
    }

    void print() {
        for (int i = 0; i < 5; i++) {
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push("Sid");
        myStack.push("atul");
        myStack.push("kartik");
        myStack.pop();
        myStack.print();
    }
}
