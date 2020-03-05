package com.app.filter;

import javax.servlet.*;
import java.io.IOException;

public class RollValidationFilter implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        filterConfig.getServletContext().log(this.getClass()+" init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        filterConfig.getServletContext().log(this.getClass()+" doFilter");
        //pre processing
        if(validate(request)){
            chain.doFilter(request,response);
            //post processing
            parseResponse(request,response);
        }
        else{
            response.getWriter().println("Don't Pass roll no");
        }

    }

    @Override
    public void destroy() {
        filterConfig.getServletContext().log(this.getClass()+" destroy");

    }
    private boolean validate(ServletRequest request){
        boolean isValid = false;
        if(request.getParameter("rollNo")==null){  //checking roll no is not passed
            isValid = true;
        }
        return isValid;
    }
    private void parseResponse(ServletRequest request,ServletResponse response) throws IOException {
    }
}
