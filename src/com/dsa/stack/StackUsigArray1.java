package com.dsa.stack;

import com.sun.tools.classfile.ConstantPool;

public class StackUsigArray1 {
    int arr[] = new int[10];
    int top = -1;
    String push(int data){
        if(top == 10){
            return "stack full";
        }
        else {
            arr[++top] = data;
        }
        return "item added";
    }

    void print(){
        for (int item:
             arr) {
            System.out.println(item);
        }
    }

    String pop(){
        if(top == -1){
            return "stack empty";
        }
        else {
            arr[top--] = 0;
        }
        return "item removed";
    }
    public static void main(String[] args) {
        StackUsigArray1 stackUsigArray1 = new StackUsigArray1();
        stackUsigArray1.push(10);
        stackUsigArray1.push(15);
        stackUsigArray1.push(20);
        stackUsigArray1.print();
        stackUsigArray1.pop();
        stackUsigArray1.pop();
        stackUsigArray1.push(25);
        System.out.println("after removal and add");
        stackUsigArray1.print();
    }
}
