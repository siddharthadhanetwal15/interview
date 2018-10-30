package com.general.equalsoveriding;

/**
 * Created by dhanetwa on 6/11/2018.
 */
public class Simple {
    //To compare two Java objects, we need to override both equals and hashCode (Good practice).
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Simple(String name, int age) {
        this.name = name;
        this.age = age;
    }
//To compare two Java objects, we need to override both equals and hashCode (Good practice).
    @Override
    public boolean equals(Object o){
        if(o==this)return true;
        if (!(o instanceof Simple)) {
            return false;
        }
        Simple simple = (Simple) o;
        return simple.name.equals(name) && simple.age == age;
    }
//Equal objects must produce the same hash code as long as they are equal, however unequal objects need not produce distinct hash codes.
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        return result;
    }

    public static void main(String[] args) {
        Simple simple = new Simple("baba", 22);
        Simple simple2 = new Simple("baba", 22);
        System.out.println(simple.equals(simple2));
        System.out.println("hashcode: simple: "+simple.hashCode()+ " simple2: "+simple2.hashCode());
        Simple simple3 = new Simple("biba", 29);
        Simple simple4 = new Simple("babu", 22);
        System.out.println(simple3.equals(simple4));
        System.out.println("hashcode: simple3: "+simple3.hashCode()+ " simple4: "+simple4.hashCode());
    }
}
