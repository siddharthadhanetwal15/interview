package com.designpatterns.singleton;

/**
 * Created by dhanetwa on 7/12/2018.
 * lazy initialization
 * use: config classes, cache, logging
 */
public class MySingleton {
    private static MySingleton abc;

    private MySingleton(){}

    public static MySingleton getInstance(){
        if(abc == null) {
            abc = new MySingleton();
        }
        return abc;
    }
}

//thread safe
class ThreadSafeSingleton {
    private static ThreadSafeSingleton threadSafeSingleton;
    private ThreadSafeSingleton(){

    }
    public synchronized static ThreadSafeSingleton getInstance(){
        if(threadSafeSingleton == null){
            threadSafeSingleton = new ThreadSafeSingleton();
        }
        return threadSafeSingleton;
    }
}

//thread safe double check
class ThreadSafeWithDoubleCheckingSingleton {
    private static ThreadSafeWithDoubleCheckingSingleton threadSafeSingleton;
    private ThreadSafeWithDoubleCheckingSingleton(){

    }
    public static ThreadSafeWithDoubleCheckingSingleton getInstance(){
        if(threadSafeSingleton == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (threadSafeSingleton == null) {
                    threadSafeSingleton = new ThreadSafeWithDoubleCheckingSingleton();
                }
            }
        }
        return threadSafeSingleton;
    }
}

//bill plough
class BillPlough {
    private BillPlough(){

    }
    private static class NestedClass{
        private static final BillPlough billPlough = new BillPlough();
    }
    public static BillPlough getInstance(){
        return NestedClass.billPlough;
    }
}

class Test{
    public static void main(String[] args) {
        MySingleton mySingleton = MySingleton.getInstance();
        ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
        ThreadSafeWithDoubleCheckingSingleton threadSafeWithDoubleCheckingSingleton = ThreadSafeWithDoubleCheckingSingleton.getInstance();
        BillPlough billPlough = BillPlough.getInstance();
    }
}
