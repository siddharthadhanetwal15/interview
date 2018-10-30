package com.general.abstraction;

public abstract class AbstractClass {
    int i;
    public AbstractClass(int data){
        this.i = data;
    }
    abstract void method();
}

class ImplementationClass extends AbstractClass{

    public ImplementationClass(int data) {
        super(data);
    }

    @Override
    void method() {
        System.out.println(i);
    }

    void defaultImpl(){
        System.out.println("default impl");
    }

    public static void main(String[] args) {
        ImplementationClass implementationClass = new ImplementationClass(20);
        implementationClass.method();
        implementationClass.defaultImpl();
    }
}
