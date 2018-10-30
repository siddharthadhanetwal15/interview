package com.general.lambda;

/**
 * Created by dhanetwa on 5/17/2018.
 */
public interface FuncInterface {
    void abstractFun(int x, int y);
    default void normalFunc(){
        System.out.println("Hello..");
    }
}
class Test{
    public static void main(String[] args) {
        FuncInterface fobj = (int x, int y) -> System.out.println(2*x*y);
        //(x,y)parameters to to abstractFun() and  System.out.println(2*x*y); is the body of abstractFun();
        fobj.abstractFun(5, 10);
    }
}
