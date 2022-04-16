package com.latestjava8;

//only one abstract  method allowed in functional interface/lambda expression
@FunctionalInterface
interface Drawable{
    void draw();
}

@FunctionalInterface
interface Human{
    void eat(String food);
}

@FunctionalInterface
interface Student{
    String result();
}

@FunctionalInterface
interface Calculator{
    int add(int num1, int num2);
}
public class LambdaExpression {
    public static void main(String[] args) {
        Drawable drawable = () -> System.out.println("no param lambda");
        drawable.draw();

        Human human = (food) -> {
            System.out.println("Human eat " + food);
        };
        human.eat("banana");

        Student student = () -> "pass";
        System.out.println("Result -> " + student.result());

        Calculator calculator = (num1, num2) -> num1+num2;
        System.out.println("sum of 23 and 44 = " + calculator.add(23,44));
    }
}
