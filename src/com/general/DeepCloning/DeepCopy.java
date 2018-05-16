package com.general.DeepCloning;

import java.util.ArrayList;

/**
 * Created by dhanetwa on 2/13/2018.
 */
class Course implements Cloneable{
    String subject1;
    String subject2;
    String subject3;
    public Course(String sub1, String sub2, String sub3) {
        this.subject1 = sub1;
        this.subject2 = sub2;
        this.subject3 = sub3;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Course{" +
                "subject1='" + subject1 + '\'' +
                ", subject2='" + subject2 + '\'' +
                ", subject3='" + subject3 + '\'' +
                '}';
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
        Student student = (Student) super.clone();
        student.course = (Course) course.clone();
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
public class DeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Course science = new Course("Physics", "Chemistry", "Biology");
        Student sid = new Student(111, "John", science);
        Student kevy = null;
        kevy = (Student)sid.clone();
        //Printing the subject3 of 'student1'
        System.out.println(sid.course.subject3);         //Output : Biology
        //Changing the subject3 of 'student2'
        kevy.course.subject3 = "Maths";
        //This change will not be reflected in original student 'student1'
        System.out.println("sid's 3rd subject: " +sid.course.subject3);       //Output : Biology

        System.out.println("kevy's 3rd subject: " + kevy.course.subject3);       //Output : Maths

        System.out.println(sid.toString());
        System.out.println(kevy.toString());


        ArrayList<String> al = new ArrayList<String>();

        //Adding elements to the ArrayList
        al.add("Apple");
        al.add("Orange");
        al.add("Mango");
        al.add("Grapes");
        System.out.println("ArrayList: "+al);

        ArrayList<String> al2 = (ArrayList<String>)al.clone();
        System.out.println("Shallow copy of ArrayList: "+ al2);

        //add and remove on original ArrayList
        al.add("Fig");
        al.remove("Orange");
        al2.add("baba");

        //Display of both ArrayLists after add & remove
        System.out.println("Original ArrayList:"+al);
        System.out.println("Cloned ArrayList:"+al2);
    }
}
