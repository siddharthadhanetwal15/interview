package com.designpatterns.decoratordp;

/**
 * Created by dhanetwa on 6/18/2018.
 */
public class LuxuryCar extends CarDecorator {
    public LuxuryCar(Car c) {
        super(c);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print("Adding features of Luxury Car.");
    }
}
