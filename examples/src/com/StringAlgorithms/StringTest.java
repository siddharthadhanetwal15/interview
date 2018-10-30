package com.StringAlgorithms;

/**
 * Created by dhanetwa on 8/6/2018.
 */
public class StringTest {
    public static void main(String[] args) {
        String s = "I am sidd1";
        int length = s.length();
        char c = s.charAt(2);
        int ascii = (int)c;
        String splitStrings[] = s.split(" ");
        char charArray[] = s.toCharArray();
        System.out.println(s.substring(1, 3));

        int intArray[] = {1,2,3,4};
        //left shift array elements
        int startElement = intArray[0];
        System.arraycopy(intArray, 1, intArray, 0, intArray.length-1);
        intArray[intArray.length-1] = startElement;
        int i=0;
        while (i<intArray.length){
            System.out.println(intArray[i]);
            i++;
        }
        int array[] = {6,7,8,9}; // -->  2left shifts - > {8,9,6,7}
        int shift = 2;// left shift twice
        int tempArray[] = new int[shift];
        for(int j=0; j<2; j++){
            tempArray[j] = array[j];
            array[j] = array[j+shift];
            array[j+shift] = tempArray[j];
        }
        String check = "am";
        System.out.println("index of "+s.indexOf(check));

        String simple = "I love India"; //o/p-> aidnI evol I //
        char simpleArray[] = simple.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int z = simpleArray.length-1; z>=0; z--){
            stringBuilder.append(simpleArray[z]);
        }
        System.out.println(stringBuilder);
        //q. find whether there is loop or not in linked list, if exists, where
        String splittedString[] = simple.split(" ");
        StringBuilder newStringBuilder = new StringBuilder();
        for(String temp : splittedString){
            char tempSplittedArray[] = temp.toCharArray();
            for(int a=tempSplittedArray.length-1; a>=0; a--){
                newStringBuilder.append(tempSplittedArray[a]);
            }
            newStringBuilder.append(" ");
        }
        System.out.println(newStringBuilder);
    }

}
