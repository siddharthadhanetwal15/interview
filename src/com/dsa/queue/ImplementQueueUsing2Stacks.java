package com.dsa.queue;

import java.util.Stack;

/**
 * Created by dhanetwa on 7/4/2018.
 */
public class ImplementQueueUsing2Stacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    void push(int data){
        stack1.push(data);
    }
    void pop(){
        if(stack2.isEmpty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        System.out.println("popped element : "+stack2.pop());
    }
    void print(){

    }

    public static void main(String[] args) {
        ImplementQueueUsing2Stacks queueUsing2Stacks = new ImplementQueueUsing2Stacks();
        queueUsing2Stacks.push(10);
        queueUsing2Stacks.push(20);
        //queueUsing2Stacks.push(30);
        queueUsing2Stacks.pop();
        queueUsing2Stacks.pop();
        queueUsing2Stacks.push(40);
        queueUsing2Stacks.pop();
    }
}
