package com.app.dao;

import com.app.model.Student;

import java.util.List;

public interface IStudentDAO {
    int saveStudent(Student student);
    List<Student> getAllStudents();
}
