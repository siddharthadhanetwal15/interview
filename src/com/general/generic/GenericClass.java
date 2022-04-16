package com.general.generic;

/**
 * Created by dhanetwa on 4/19/2018.
 */
public class GenericClass {
    public static void main(String[] args) {
        //instance of integer type
        Test<Integer> test = new Test<>(15);
        System.out.println(test.getObj());

        //instance of String type
        Test<String> test1 = new Test<>("Gazab.. Its string!!");
        System.out.println(test1.getObj());

        //multiple type
        Test2<Integer, String> test2 = new Test2<>(99, "multiple type param");
        System.out.println(test2.getObj1() + " , " + test2.getObj2());
    }
}

class Test<T> {
    T obj;

    Test(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return this.obj;
    }
}

class Test2<T, U> {
    T obj1;
    U obj2;

    Test2(T obj1, U obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public T getObj1() {
        return obj1;
    }

    public U getObj2() {
        return obj2;
    }
}
