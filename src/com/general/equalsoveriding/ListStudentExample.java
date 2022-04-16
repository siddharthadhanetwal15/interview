package com.general.equalsoveriding;

import java.util.*;

/**
 * Created by dhanetwa on 6/11/2018.
 */
public class ListStudentExample {
    public static void main(String[] args) {
        //remove duplicate student from list, consider fname and lname
        List<Student> studentList = new ArrayList<>();
        Student s1 = new Student("Amit", "Shah");
        Student s2 = new Student("Narendra", "Modi");
        Student s3 = new Student("Narendra", "Modi");
        Student s4 = new Student("Narendra", "Modi");
        Student s5 = new Student("Amit", "Shah");
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        List<Student> uniques = new ArrayList<>();
        for (Student element : studentList) {
            if (!uniques.contains(element)) {
                uniques.add(element);
            }
        }
    }


}

class Student {
    private String fname;
    private String lname;

    public Student(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return student.fname.equals(fname) && student.lname.equals(lname);
    }

    @Override
    public int hashCode() {
        int result = fname != null ? fname.hashCode() : 0;
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        return result;
    }
}