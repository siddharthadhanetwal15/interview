package com.dsa.stack;

import java.util.ListIterator;
import java.util.Stack;

/**
 * Created by dhanetwa on 7/4/2018.
 */
public class ElementsConsecutiveOrNot {
    boolean checkConsecutiveOrNot(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        ListIterator stackIterator = stack.listIterator();
        while (stackIterator.hasNext()) {
            int i = (int) stackIterator.next();
            int j = (int) stackIterator.next();
            if (i - j != 1) {
                tempStack.push(i);
                tempStack.push(j);
            }
        }
        if (checkOdd(stack)) {

        } else {

            int size = stack.size();
            int pairs = size / 2;
            while (pairs != 0) {
                int i = 2;
                while (i != 0) {
                    tempStack.push(stack.pop());
                    i--;
                }

                tempStack.push(stack.pop());
                pairs--;
            }
        }
        return true;
    }

    boolean checkOdd(Stack<Integer> stack) {
        if (stack.size() / 2 == 1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(6);
        stack.push(-2);
        stack.push(-3);
        stack.push(10);
        ElementsConsecutiveOrNot consecutiveOrNot = new ElementsConsecutiveOrNot();
        System.out.println(consecutiveOrNot.checkConsecutiveOrNot(stack));
    }
}
