package com.dsa.priorityqueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by dhanetwa on 9/10/2018.
 */
public class CustomizedComparator {

    public static void main(String[] args) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(5, new CGPAComparator());
        Student s1 = new Student(7, "rani");
        Student s2 = new Student(5, "sid");
        Student s3 = new Student(9, "shweta");
        priorityQueue.add(s1);
        priorityQueue.add(s2);
        priorityQueue.add(s3);
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            Student s = priorityQueue.remove();
            System.out.println(s.getName());
        }

    }
}

class CGPAComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCgpa(), o2.getCgpa());
    }
}

class Student {
    private int cgpa;
    private String name;

    public Student(int cgpa, String name) {
        this.cgpa = cgpa;
        this.name = name;
    }

    public int getCgpa() {
        return cgpa;
    }

    public void setCgpa(int cgpa) {
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}