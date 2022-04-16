package com.general.InnerClasses;

/**
 * Created by dhanetwa on 4/20/2018.
 */
class OuterClass {
    // static member
    static int outer_x = 10;
    // instance(non-static) member
    int outer_y = 20;
    // private member
    private static int outer_private = 30;

    static class StaticNestedClass {
        void display() {
            System.out.println("outer x= " + outer_x);
            System.out.println("outer_private = " + outer_private);
        }
    }
}

// Driver class
public class StaticNestedClassDemo {
    public static void main(String[] args) {
        // accessing a static nested class
        OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();
        staticNestedClass.display();
    }
}
