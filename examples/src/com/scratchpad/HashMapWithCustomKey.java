package com.scratchpad;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dhanetwa on 9/15/2018.
 * this example will cover all scenarios of using custom key in hashmap
 * overiding of equals and hashcode is necessary because:
 * 1. As per concept of HM, keys will be unique so when you add two objects of same content, HM should keep latest one only.
 * 2. and when you retireve an object it should compare its content and then return value Therefore you will get null value.. line 26
 * 3. mutable prob: line 31: Once the Fruit Object is mutated, the hashcode of that object is going to change. Now, if we try to retrieve it in step 3 (with the different hashcode), it will go to a different bucket and not be able to get the value. Now, the object placed in the HashMap is lost forever.
 */
public class HashMapWithCustomKey {
    public static void main(String[] args) {
        Fruits banana = new Fruits("banana", 40);
        Fruits apple = new Fruits("apple", 120);
        Fruits pineapple = new Fruits("apple", 120); //this is to check.. this is why equals overiding is needed
        Fruits pomegrenate = new Fruits("pomegrenate", 90);
        Map<Fruits, String> map = new HashMap<>();
        map.put(banana, "banana");
        map.put(apple, "apple");
        map.put(pineapple, "duplicate apple");
        map.put(pomegrenate, "pomegrenate");
        System.out.println(map);
        Fruits duplicate = new Fruits("apple", 120);
        //System.out.println(map.get(duplicate)); --> o/p null when equals not overided
        System.out.println(map.get(duplicate));
        //prob2: mutability
        banana.setPrice(55);
        System.out.println(map.get(banana));// o/p --> null, Once the Fruit Object is mutated, the hashcode of that object is going to change. Now, if we try to retrieve it in step 3 (with the different hashcode), it will go to a different bucket and not be able to get the value. Now, the object placed in the HashMap is lost forever.

        Fruits kiwi = Fruits.FruitBuilder.aFruit().withName("kiwi").withPrice(200).build();
        Fruits immutableKiwi = Fruits.FruitBuilder.aFruit(kiwi).withName("kiwi").withPrice(200).build();
        map.put(kiwi, "kiwi");
        System.out.println(map.get("kiwi"));
        kiwi.setPrice(300);
        System.out.println("after changing" + map.get("kiwi"));
    }
}

final class Fruits{
    String name;
    int price;

    public Fruits(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Fruits(FruitBuilder fruitBuilder) {
        this.name = fruitBuilder.name;
        this.price = fruitBuilder.price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fruits fruits = (Fruits) o;

        if (price != fruits.price) return false;
        return name != null ? name.equals(fruits.name) : fruits.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + price;
        return result;
    }
    public static final class FruitBuilder{
        private String name;
        private int price;
        public FruitBuilder(){

        }
        public static FruitBuilder aFruit() {
            return new FruitBuilder();
        }
        public static FruitBuilder aFruit(Fruits fruits) {
            return aFruit().withName(fruits.getName()).withPrice(fruits.getPrice());
        }
        public FruitBuilder withPrice(int price) {
            this.price = price;
            return this;
        }
        public FruitBuilder withName(String name) {
            this.name = name;
            return this;
        }
        public Fruits build(){
            return new Fruits(this);
        }
    }
}

