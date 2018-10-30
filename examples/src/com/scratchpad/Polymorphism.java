package com.scratchpad;

/**https://www.geeksforgeeks.org/output-java-program-set-25-polymorphism/
 * Created by dhanetwa on 9/16/2018.
 */
public class Polymorphism {
    public static void main(String[] args) {
        // below is upcasting and it is always allowed if sub class is extending super class.. a = new D(); -- error
        A a = new B();
        a.sing();
        a = new C();
        a.sing();
        //why below line is allowed.. because a is holding a reference of C only. so at runtime it is allowing.
        //if you keep it like this a=new B(), then you try to cast.. it will throw class cast exception
        //
        ((C) a).eat();

        X x = new X();
        x.play();
        x = new Y();
        x.play();
        x = new Z();
        x.play();
        ((Z) x).dance();
    }
}

class X{
    void play(){
        System.out.println("X");
    }
}

class Y extends X{
    void play(){
        System.out.println("Y");
    }
}

class Z extends X{
    void play(){
        System.out.println("Z");
    }

    void dance(){
        System.out.println("z dance");
    }
}

interface A{
    void sing();
}
class B implements A{

    @Override
    public void sing() {
        System.out.println(B.class.getName());
    }
}

class C implements A{
    @Override
    public void sing() {
        System.out.println(C.class.getName());
    }

    void eat(){
        System.out.println("eat");
    }
}

class D{
    public void sing() {
        System.out.println(D.class.getName());
    }
}
