package com.latestjava8;
/*Java provides a new feature called method reference in Java 8. Method reference is used to refer method of functional interface. It is compact and easy form of lambda expression. Each time when you are using lambda expression to just referring a method, you can replace your lambda expression with method reference*/
//static method, constructor, instance method
@FunctionalInterface
interface Music{
    void sing();
}

@FunctionalInterface
interface Calculate{
    int add(int num1, int num2);
}

interface Messageable{
    MethodReference getMessage(String msg);
}

interface Sayable{
    void say();
}
public class MethodReference {
    public MethodReference(){}
    public MethodReference(String msg) {
        System.out.println(msg);
    }

    static void singMusic(){
        System.out.println("la la la");
    }

    static int addNum(int num1, int num2){
        return num1+num2;
    }

    public void saySomething(){
        System.out.println("Hello, this is non-static method.");
    }

    public static void main(String[] args) {
        Music music = MethodReference::singMusic;
        music.sing();

        Calculate calculate = MethodReference::addNum;
        System.out.println(calculate.add(23,44));

        Messageable messageable = MethodReference::new;
        messageable.getMessage("this is from construction method reference");

        Sayable sayable = new MethodReference()::saySomething;
        sayable.say();
    }
}
