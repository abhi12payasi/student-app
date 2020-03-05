<%@ page import="java.util.List" %>

<%

     ServletContext servletContext = request.getServletContext();
     List<Student> studentList = servletContext.getAttribute("data");
     out.println(studentList);
%>