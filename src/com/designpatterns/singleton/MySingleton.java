package com.designpatterns.singleton;

/**
 * Created by dhanetwa on 7/12/2018.
 */
public class MySingleton {
    private static MySingleton abc;

    private MySingleton() {
    }

    public static MySingleton getInstance() {
        if (abc == null) {
            abc = new MySingleton();
        }
        return abc;
    }
}

class Test {
    public static void main(String[] args) {
        MySingleton mySingleton = MySingleton.getInstance();
    }
}

// Java program to create Thread Safe
// Singleton class
class GFG1
{
    // private instance, so that it can be
// accessed by only by getInstance() method
    private static GFG1 instance;

    private GFG1()
    {
        // private constructor
    }

    //synchronized method to control simultaneous access
    synchronized public static GFG1 getInstance()
    {
        if (instance == null)
        {
            // if instance is null, initialize
            instance = new GFG1();
        }
        return instance;
    }
}



// Java code to explain double check locking
class GFG
{
    // private instance, so that it can be
    // accessed by only by getInstance() method
    private static GFG instance;

    private GFG()
    {
        // private constructor
    }

    public static GFG getInstance()
    {
        if (instance == null)
        {
            //synchronized block to remove overhead
            synchronized (GFG.class)
            {
                if(instance==null)
                {
                    // if instance is null, initialize
                    instance = new GFG();
                }

            }
        }
        return instance;
    }
}