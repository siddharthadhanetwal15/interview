package com.general.ShallowCloning;

import java.util.Collection;

/**
 * Created by dhanetwa on 2/13/2018.
 * In the above example, ‘student1‘ is an object of ‘Student‘ class which has three fields – id, name and course. ‘course‘ is a reference variable pointing to a ‘Course‘ type object. Clone of ‘student1‘ is created by calling clone method on it and assigned it to ‘student2‘. As default version of clone method creates the shallow copy, the ‘course‘ field of both ‘student1‘ and ‘student2‘ will be pointing to same ‘Course‘ object.
 * So, any changes made to this object through ‘student2‘ will be reflected in ‘student1‘ or vice-versa.
 */
class Course {
    String subject1;
    String subject2;
    String subject3;

    public Course(String sub1, String sub2, String sub3) {
        this.subject1 = sub1;
        this.subject2 = sub2;
        this.subject3 = sub3;
    }
}

class Student implements Cloneable {

    int id;
    String name;
    Course course;

    public Student(int id, String name, Course course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Course course = new Course("Physics", "Chemistry", "Biology");
        Student sid = new Student(1, "Sid", course);
        Student kevy = null;
        kevy = (Student) sid.clone();
        //before change
        System.out.println("Before: " + sid.course.subject3);
        kevy.course.subject3 = "Maths";
        kevy.id = 2;
        //after change
        System.out.println("After sid course: " + sid.course.subject3);
        System.out.println("student sid id: " + sid.id);
        System.out.println("student kevy id: " + kevy.id);
    }
}
