package com.scratchpad;

/**
 * Created by dhanetwa on 9/16/2018.
 */
public class ConstructorOutputImp {
    public static void main(String[] args) {
        new G().G();
    }
}

class G {
    public G(int i) {
        System.out.println(1);
    }

    public G() {
        this(10);

        System.out.println(2);
    }

    void G() {
        G(10); // this will call method
        //new G(10);
        System.out.println(3);
    }

    void G(int i) {
        System.out.println(4);
    }
}
