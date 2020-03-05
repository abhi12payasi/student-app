package com.app.filter;

import javax.servlet.*;
import java.io.IOException;

public class NameValidationFilter implements Filter {

    private FilterConfig filterConfig ;
    public NameValidationFilter() {
        //filterConfig.getServletContext().log(this.getClass()+ " constructor");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        filterConfig.getServletContext().log(this.getClass()+" init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        filterConfig.getServletContext().log(this.getClass()+ " doFilter");
        if(validate(request)){
            chain.doFilter(request,response);
        }
        else{
            response.getWriter().println("name invalid !!");
        }

    }

    @Override
    public void destroy() {
        filterConfig.getServletContext().log(this.getClass()+" destroy");

    }
    private boolean validate(ServletRequest request){
        boolean isValid = false;
        if(request.getParameter("name").length()>=4){
            isValid = true;
        }
        return isValid;
    }
}
