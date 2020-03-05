package com.app.service;

import com.app.model.Student;

import java.util.List;

public interface IStudentService {
    int saveStudent(Student student);
    List<Student> getAllStudents();
}
