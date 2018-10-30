package com.StringAlgorithms;

import java.util.*;

/**
 * Created by dhanetwa on 9/2/2018.
 */
public class ArrayOperatios {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String abc = in.next();
        String stringArray[] = abc.split(",");
        System.out.println(Arrays.toString(stringArray));
        int n = in.nextInt();
        int inputArray[] = new int[n];
        int j=0;
        while(n!=0){
            inputArray[j] = in.nextInt();
            j++;
            n--;
        }
        System.out.println("input from keyboard: "+Arrays.toString(inputArray));

        int arr[] = {6, 9, 3, 4, 5};
        int arr2[] = new int[7];
        arr2 = new int[]{2, 4};

        Arrays.sort(arr);
        for(int item : arr){
            System.out.println(item);
        }
        System.out.println("index: " + Arrays.binarySearch(arr, 5));
        Integer integerArr[] = {4, 2, 5, 6, 1};
        List<Integer> list = Arrays.asList(integerArr);
        System.out.println("list element at 2nd pos.: " + list.get(1));

        System.out.println("sum");
        int sum= 0;
        for(int item : arr){
            sum += item;
        }
        System.out.println(sum);
        System.out.println("find index");
        int index = 0;
        int element = 6;
        for(int item : arr){
            if(item==element){
                System.out.println("index is :"+ index);
            }else{
                index++;
            }
        }
        System.out.println("consecutive");
        Arrays.sort(integerArr);
        System.out.println(Arrays.toString(integerArr));
        Set<Integer> hs = new HashSet<>();
        for(int i = 0; i<integerArr.length-1; i++){
            int diff = integerArr[i+1] - integerArr[i];
            if(diff == 1){
                hs.add(integerArr[i]);
                hs.add(integerArr[i+1]);
            }else{
                break;
            }
        }
        System.out.println(hs);
    }
}
