package com.general.String;

/**
 * Created by dhanetwa on 4/18/2018.
 */
public class RemoveTrailingZeroes {
    public static String removeTrailingZerothroughString(String str){
        int i = 0;
        while(str.charAt(i) == '0'){
            i++;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.replace(0,i,"");
        return stringBuffer.toString();
    }
    public static void main(String[] args) {
        //method1
        String trailingZeroesString = "00012122";
        Integer removedTrailingZeroes = Integer.parseInt(trailingZeroesString);
        System.out.println(removedTrailingZeroes);
        //
        System.out.println(removeTrailingZerothroughString(trailingZeroesString));
    }
}
