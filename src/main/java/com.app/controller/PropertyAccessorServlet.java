package com.app.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class PropertyAccessorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().log(this.getClass()+ " doGet");

        String propertiesObj = getServletContext().getAttribute("propertiesObj").toString();

        response.getWriter().print(propertiesObj);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        getServletContext().log(this.getClass()+ " init");
    }

    @Override
    public void destroy() {
        super.destroy();
        getServletContext().log(this.getClass()+ " destroyed");
    }
}
