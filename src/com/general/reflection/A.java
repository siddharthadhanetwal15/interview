package com.general.reflection;

/**
 * Created by dhanetwa on 5/6/2018.
 */
class A {
   A(){
       System.out.println("a");
   }
   void hello(){
       System.out.println("helloA");
   }
}
class B extends A{
    B(){
        System.out.println("b");
    }

    void hello(){
        //super.hello();
        System.out.println("helloB");
    }
}
class C extends B{
    C(){
        System.out.println("c");
    }

    void hello(){
        //super.hello();
        System.out.println("helloC");
    }
    public static void main(String[] args) {
        A c = new C();
        c.hello();
    }
}