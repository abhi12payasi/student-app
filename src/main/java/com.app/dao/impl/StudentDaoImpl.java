package com.app.dao.impl;

import com.app.dao.IStudentDao;
import com.app.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao {
    private static List<Student> studentList;
    static {
        studentList = new ArrayList<>();
    }
    @Override
    public int saveStudent(Student student) {
         studentList.add(student);
         return student.getRollNo();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }
}
