package com.app.service.impl;

import com.app.dao.IStudentDAO;
import com.app.dao.impl.StudentDAOImpl;
import com.app.model.Student;
import com.app.service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private static IStudentDAO studentDAO;
    static {
        studentDAO = new StudentDAOImpl();;
    }
    @Override
    public int saveStudent(Student student) {
        return studentDAO.saveStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
