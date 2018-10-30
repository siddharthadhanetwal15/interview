package com.StringAlgorithms;

import java.util.Scanner;

/**
 * Created by dhanetwa on 9/2/2018.
 */
public class BinaryAddition {
    void method1(String first, String second){
        int firstNo = Integer.parseInt(first, 2);
        int secondNo = Integer.parseInt(second, 2);
        int sum = firstNo+secondNo;
        System.out.println(Integer.toBinaryString(sum));
    }

    void method2(String num1, String num2){
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        StringBuilder buf = new StringBuilder();
        int carry = 0;
        while (p1 >= 0 || p2 >= 0) {
            int sum = carry;
            if (p1 >= 0) {
                sum += num1.charAt(p1) - '0';
                p1--;
            }
            if (p2 >= 0) {
                sum += num2.charAt(p2) - '0';
                p2--;
            }
            carry = sum >> 1; // right shift operator.. shifts binary digits to that positions
            sum = sum & 1;
            buf.append(sum == 0 ? '0' : '1');
        }
        if (carry > 0) {
            buf.append('1');
        }
        buf.reverse();
        System.out.println(buf.toString());
    }

    void method3(String a, String b){
        // Initialize result
        String result = "";

        // Initialize digit sum
        int s = 0;

        // Travers both strings starting
        // from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {

            // Comput sum of last
            // digits and carry
            s += ((i >= 0)? a.charAt(i) - '0': 0);
            s += ((j >= 0)? b.charAt(j) - '0': 0);

            // If current digit sum is
            // 1 or 3, add 1 to result
            result = (char)(s % 2 + '0') + result;

            // Compute carry
            s /= 2;

            // Move to next digits
            i--; j--;
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        String first = "001";
        String second = "010";
        BinaryAddition binaryAddition = new BinaryAddition();
        binaryAddition.method1(first, second);
        binaryAddition.method2(first, second);
        binaryAddition.method3(first, second);
    }
}
