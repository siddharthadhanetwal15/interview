package com.ge;

public class Problem {
    public static void main(String[] args) {
        Problem problem = new Problem();
        int arr[] = {12, 17, 11, 15};
        int targetSum = 27;
        int out[] = problem.findIndex(arr, targetSum);
        for (int i=0; i<out.length; i++){
            System.out.println(out[i]);
        }
    }

    int[] findIndex(int arr[], int sum){
        int output[] = new int[2];
        for(int i=0; i<arr.length-1; i++){
            for(int j=1; j<arr.length; j++) {
                if (arr[i] + arr[j] == sum){
                    output[0] = i;
                    output[1] = j;
                    return output;
                }
            }
        }
        return output;
    }
}
