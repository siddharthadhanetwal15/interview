package com.dsa.stack;

import java.util.Stack;

/**
 * Created by dhanetwa on 7/1/2018.
 */
public class SymbolBalancingCheck {
    static boolean checkSymbolBalancing(char[] stringToCheck) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < stringToCheck.length; i++) {
            if (stringToCheck[i] == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (stringToCheck[i] == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(stringToCheck[i]);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        char[] stringToCheck = {'(', ')', '(', '(', ')', ']'};
        if (checkSymbolBalancing(stringToCheck)) {
            System.out.println("balanced");
        } else {
            System.out.println("un balanced");
        }
    }
}
