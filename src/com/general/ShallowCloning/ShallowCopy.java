package com.general.ShallowCloning;

/**
 * Created by dhanetwa on 2/13/2018.
 */
class Course{
    String subject1;
    String subject2;
    String subject3;
    public Course(String sub1, String sub2, String sub3) {
        this.subject1 = sub1;
        this.subject2 = sub2;
        this.subject3 = sub3;
    }
}
class Student implements Cloneable{
    int id;
    String name;
    Course course;

    public Student(int id, String name, Course course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Course course = new Course("Physics","Chemistry","Biology");
        Student sid = new Student(1, "Sid", course);
        Student kevy = null;
        kevy = (Student) sid.clone();
        //before change
        System.out.println("Before: " + sid.course.subject3);
        kevy.course.subject3 = "Maths";
        //after change
        System.out.println("After: " + sid.course.subject3);
    }
}
