package com.designpatterns.decoratordp;

/**
 * Created by dhanetwa on 6/18/2018.
 */
public class CarDecorator implements Car {
    protected Car car;
    public CarDecorator(Car c){
        this.car = c;
    }
    @Override
    public void assemble() {
        this.car.assemble();
    }
}
