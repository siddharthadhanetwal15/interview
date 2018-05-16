package com.general.reflection;

/**
 * Created by dhanetwa on 5/6/2018.
 */
// Java program to demonstrate working of newInstance()

// Sample classes

public class NewInstanceTest {
    // This method creates an instance of class whose name is
    // passed as a string 'c'.
    public static void fun(String c)  throws InstantiationException,
            IllegalAccessException, ClassNotFoundException
    {
        // Create an object of type 'c'
        Object obj = Class.forName(c).newInstance();

        // This is to print type of object created
        System.out.println("Object created for class:"
                + obj.getClass().getName());
    }
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        fun("A");
    }
}
