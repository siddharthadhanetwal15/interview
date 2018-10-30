package com.dsa.stack;

/**
 * Created by dhanetwa on 6/30/2018.
 */
public class StackUsingArray {
    private int[] stack;
    int top=-1;
    int capacity=10;
    StackUsingArray(){
        stack = new int[capacity];
    }
    void push(int data){
        if(stack.length == top){
            System.out.println("item can't be inserted!");
        }else{
            stack[++top] = data;
        }
    }

    void pop(){
        if(top == 0){
            System.out.println("no item to pop");
        }else{
            stack[top--] = 0;
        }
    }

    int getTop(){
        return stack[top];
    }

    void print(){
        for(int i = 0; i<stack.length; i++) {
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        StackUsingArray stackUsingArray = new StackUsingArray();
        stackUsingArray.push(10);
        stackUsingArray.push(20);
        stackUsingArray.push(30);
        stackUsingArray.push(40);
        stackUsingArray.pop();
        stackUsingArray.print();
        System.out.println("top element is: "+ stackUsingArray.getTop());
    }
}
