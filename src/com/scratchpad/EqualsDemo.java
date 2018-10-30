package com.scratchpad;

/**
 * Created by dhanetwa on 9/7/2018.
 */
public class EqualsDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee("Tina");
        Employee e2 = new Employee("Mina");
        Employee e3 = new Employee("Tina");
        Employee e4 = new Employee("");
        System.out.println(e1.equals(e2));
        System.out.println(e1.equals(e3));
        System.out.println(e1.equals(e4));

    }
}
class Employee{
    private String name;
    Employee(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.name.equals(((Employee)obj).getName())){
            return true;
        }
        else
            return false;
    }
}
