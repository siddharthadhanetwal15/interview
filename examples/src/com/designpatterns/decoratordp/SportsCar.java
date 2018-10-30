package com.designpatterns.decoratordp;

/**
 * Created by dhanetwa on 6/18/2018.
 */
public class SportsCar extends CarDecorator {
    public SportsCar(Car c) {
        super(c);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding features of sports car!!");
    }
}
