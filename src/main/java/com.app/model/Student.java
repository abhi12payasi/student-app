package com.app.model;

public class Student{
    private int rollNo;
    private String name;
    private String university;

    public Student() {
    }

    public Student(int rollNo, String name, String university) {
        this.rollNo = rollNo;
        this.name = name;
        this.university = university;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", university='" + university + '\'' +
                '}';
    }
}