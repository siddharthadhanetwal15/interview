package com.dsa.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    /*static int val = 3;
diff between hash map and linked map.. sorting by key or value?
In Java 8, which of the following interfaces is a part of the collections framework but does not inherit from the collection interface?
In Java, which of the following methods is used for grouping objects and storing the results in a Map instance?
UncheckedIOException
1. PrimitiveIterator
2. StringJoiner
3. StringFilter
4. UncheckedIOException
subList() - portion of arraylist

    static int getValue()
    {
        return val--;
    }

    public static void main(String args[])
    {
        int n;
        for(int i=0; i < 5; i++)
        {
            n = getValue();
            assert n > 2;
            System.out.println(" " + n);
        }
    }*/
    public static void main(String[] args)
    {
        String regex = "\\b(\\d{3})\\d{7}\\b";
        Pattern p = Pattern.compile(regex);
        String source = "3342449027, 2339829, and 6152534734";

        Matcher m = p.matcher(source);

        while(m.find())
        {
            String val = m.group();
            String val2 = m.group(1);
            System.out.println("Val: " + val + ", Val2: " + val2);
        }
    }
}
interface StrFunc
{
    String disp(String n);
}

class HackerEarth
{
    public static void main(String args[])
    {
        StrFunc output = (str) -> {
            String result = "";
            int a;
            for(a = str.length()-1; a >= 0; a--)
                result += str.charAt(a);
            return result;
        };

        System.out.println(output.disp("HACKEREARTH"));
    }
}
class Add{

    protected int addNumbers(int a, int b){
        return a+b;
    }
}

class B extends Add{
    public static void main(String []aa)
    {
        B obj = new B();
        System.out.println(obj.addNumbers(11, 22));
    }
}

class HackerEarth1
{
    public static void main(String [] args)
    {
        HackerEarth1 h = new HackerEarth1();
        h.start();
    }

    void start()
    {
        String s1 = "hack";
        String s2 = val(s1);
        System.out.println(s1 + " " + s2);
    }

    String val(String s1)
    {
        s1 = s1 + "earth";
        System.out.print(s1 + " ");
        return "hackathons";
    }
}
class HackerEarth2
{
    public static void main(String[] args)
    {
        int[] array = {6,9,8};
        List<Integer> list = new ArrayList<>();
        list.add(array[0]);
        list.add(array[2]);
        list.set(1, array[1]);
        list.remove(0);
        System.out.println(list);
    }
}
class Game {
    public int number;
}

class HackerEarth3{
    public void PlayIt(int i , Game p){
        i = 5;
        p.number = 8;
    }

    public static void main(String args[]){
        int x = 0;
        Game p = new Game();
        new HackerEarth3().PlayIt(x, p);
        System.out.println(x + " " + p.number);
    }
}
class HackerEarth4 {
    public static void Method() {

    }
    public static void main(String [] args){
        try{
            Method();
            System.out.print("H");
        }catch (Exception ex) {
            System.out.print("A");
        } finally {
            System.out.print("C");
        }
        System.out.print("K");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }, "sid");
    }
}
class A1
{
    public int x;
    private int y;
    protected int z;
}
class A2 extends A1 {
    protected int a;
    private int b;}
class A3 extends A2 {
    private int q;

}
class HackerEarth5
{

    public static void main(String args[])
    {
        System.out.printf("%s and %<S","Hello");
    }

}
class HR{
    public static void main(String[] args) throws IOException {
        //rotate array left https://www.geeksforgeeks.org/array-rotation/
        int arr[] = {1, 2, 3, 4, 5};
        int d = 4;
        int last = arr.length-1;
        for(int i = 1; i<=4; i++){
            int tempLast = arr[last]; //5
            arr[last] = arr[0];  // 1
            for(int j=0; j<arr.length-1; j++){
                arr[j] = arr[j+1];  // 2
            }
            arr[last-1] = tempLast;
        }
        System.out.println(Arrays.toString(arr));

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d2 = scan.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n;i++) {
            array[(i+n-d2)%n] = scan.nextInt();
        }
        for(int i=0; i<n;i++) {
            System.out.print(array[i] + " ");
        }

        //to read input from hackerearth
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n2 = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.println(n2*2);
        System.out.println(str);

        String input = br.readLine();
        char charArr[] = input.toCharArray();
        int cz=0;
        int co=0;
        for(int i=0; i<charArr.length; i++){
            if(charArr[i] == 'z'){
                cz++;
            }
            if(charArr[i] == 'o'){
                co++;
            }
        }
        if(co == (2*cz)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
