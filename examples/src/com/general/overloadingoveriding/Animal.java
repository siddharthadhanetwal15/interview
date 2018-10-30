package com.general.overloadingoveriding;

import java.io.IOException;

/**
 * Created by dhanetwa on 6/20/2018.
 */
public class Animal {
    public void move() throws IOException{
        System.out.println("Animal moves");
    }

    public static void main(String[] args) throws IOException{
        Animal a = new Animal();
        a.move();
        Animal b = new Dog();
        b.move();
        ((Dog) b).bark();
        Dog d = (Dog)new Animal();
        d.move();
    }
}
class Dog extends Animal{
    public void move() throws IOException{
        System.out.println("Dog moves");
    }
    int move(int a){
       return 1; //overloaded
    }
    public void bark(){
        System.out.println("dog barks");
    }
}