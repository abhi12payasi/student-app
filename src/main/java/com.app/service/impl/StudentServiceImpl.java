package com.app.service.impl;

import com.app.dao.IStudentDao;
import com.app.dao.impl.StudentDaoImpl;
import com.app.model.Student;
import com.app.service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private static IStudentDao studentDAO;
    static {
        studentDAO = new StudentDaoImpl();;
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
