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
import java.util.List;

public class StudentDataServlet extends HttpServlet {
    private static IStudentService studentService;
    static {
        studentService = new StudentServiceImpl();
    }
    public StudentDataServlet(){
        //getServletContext().log(this.getClass()+ " constructor");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().log(this.getClass()+ " doGet");
        PrintWriter pw = response.getWriter();

        List<Student> list = studentService.getAllStudents();

        request.setAttribute("data" , list);

        String result ;
        if (list.size() == 0) {
            result = "No student found!";
        }else{
            result = list.toString();
        }

        request.setAttribute("result" ,result);

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