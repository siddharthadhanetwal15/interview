package com.general.InnerClasses.anonymous;

/**
 * Created by dhanetwa on 4/20/2018.
 */

interface Age {
    int x = 21;

    void getAge();
}

public class AnonymousClassDemo {

    public static void main(String[] args) {
        Age age = new Age() {

            @Override
            public void getAge() {
                System.out.println("My age is " + x);
            }
        };
        age.getAge();
    }
}