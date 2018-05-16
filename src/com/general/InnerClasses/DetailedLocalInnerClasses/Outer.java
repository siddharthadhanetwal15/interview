package com.general.InnerClasses.DetailedLocalInnerClasses;

/**
 * Created by dhanetwa on 4/20/2018.
 */
public class Outer {
    int x = 10;
    int y = 20;
    LocalInner localInner = new LocalInner();
    void callInnerDisplay() {

        localInner.display();
    }
    class LocalInner {
        void display() {
            System.out.println(x);
        }
    }
    public void check(){
        if(x==10) {
            class LocalInner2 {
                void display() {
                    System.out.println(y);
                }
            }
            LocalInner2 localInner2 = new LocalInner2();
            localInner2.display();
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.callInnerDisplay();
        outer.check();
    }
}
