package com.general.castingQuestions;

public class Example1 {
    void method1() {
        System.out.println("Example1");
    }

    public static void main(String[] args) {
        Example1 example1 = new B();
        example1.method1();

        B b = (B) new Example1(); //upcasting is possible but downcasting is not. class cast exception
        b.method1();
        /*http://www.codejava.net/java-core/the-java-language/what-is-upcasting-and-downcasting-in-java*/
    }
}

class B extends Example1 {
    void method1() {
        System.out.println("B");
    }
}