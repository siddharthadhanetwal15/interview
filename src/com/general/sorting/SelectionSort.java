package com.general.sorting;

/**
 * Created by dhanetwa on 2/27/2018.
 */
public class SelectionSort {
    private void sort(int arr[]) {
        int temp = 0;
        int sub[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {40, 23, 11, 55, 10, 20};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        // 10, 23, 11, 55, 40, 20
        // 10, 11, 23, 55, 40, 20
        // 10, 11, 20, 55, 40, 23
        // 10, 11, 20, 23, 40, 55 -- sorted(selection)

        //23, 40, 11, 55, 10, 20
        //11, 40, 23, 55, 10, 20
        //10, 40, 23, 55, 11, 20

    }
}
