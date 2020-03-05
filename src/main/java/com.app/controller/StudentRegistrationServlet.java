package com.app.controller;

import com.app.model.Student;
import com.app.service.IStudentService;
import com.app.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentRegistrationServlet extends HttpServlet {
    private static int rollNo = 0;
    private static IStudentService studentService;
    static {
        studentService = new StudentServiceImpl();
    }
    public StudentRegistrationServlet(){
        //this.getServletContext().log(this.getClass()+" constructor");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().log(this.getClass()+ " doPost");
        PrintWriter pw = resp.getWriter();
        String name = req.getParameter("name");
        String university = req.getParameter("university");
        rollNo++; // for sequential roll no generation
        Student student = new Student(rollNo,name,university);

        int rno = studentService.saveStudent(student);

        pw.println("Student with id "+rno+" registered !!");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        getServletContext().log(this.getClass()+ " init");
    }

    @Override
    public void destroy() {
        super.destroy();
        getServletContext().log(this.getClass()+ " destroy");
    }
}
