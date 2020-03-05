package com.app.filter;

import com.app.model.Student;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class ResponseConverterFilter implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        filterConfig.getServletContext().log(this.getClass()+" init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        filterConfig.getServletContext().log(this.getClass()+" doFilter");
        chain.doFilter(request,response);
        //post processing
        writeResponse(request,response);

    }

    @Override
    public void destroy() {
        filterConfig.getServletContext().log(this.getClass()+" destroy");
    }

    private void writeResponse(ServletRequest request , ServletResponse response) throws IOException {
        String accept = ((HttpServletRequest)request).getHeader("accept");
        List<Student> studentList = (List<Student>)request.getAttribute("data");
        if(accept.equals("application/json")){ // convert object to json
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(studentList);
            response.setContentType("application/json");
            response.getWriter().print(json);
        }
        else if(accept.equals("application/xml")) { // convert object to xml
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(studentList);
            response.setContentType("application/xml");
            response.getWriter().print(xml);
        }
        else{ // text response
            response.getWriter().print(request.getAttribute("result"));
        }
    }
}
