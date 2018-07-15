package com.designpatterns.singleton;

/**
 * Created by dhanetwa on 7/12/2018.
 */
public class MySingleton {
    private static MySingleton abc;

    private MySingleton(){}

    public static MySingleton getInstance(){
        abc = new MySingleton();
        return abc;
    }
}

class Test{
    public static void main(String[] args) {
        MySingleton mySingleton = MySingleton.getInstance();
    }
}