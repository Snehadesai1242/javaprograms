package com.Experiment2;

import java.util.*;

class Student {
    int rollNo;
    String name;
    int marks;

    Student(int r, String n, int m) {
        rollNo = r;
        name = n;
        marks = m;
    }

    public String toString() {
        return rollNo + " " + name + " " + marks;
    }
}

class SortByMarks implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return a.marks - b.marks;
    }
}

public class StudentRecord {
    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student(3,"Rahul",95));
        list.add(new Student(1,"Sneha",85));
        list.add(new Student(2,"Amit",89));

        System.out.println("Original List");
        for(Student s : list) {
            System.out.println(s);
        }

        Collections.sort(list, new SortByMarks());

        System.out.println("\nSorted by Marks");
        for(Student s : list) {
            System.out.println(s);
        }
    }
}