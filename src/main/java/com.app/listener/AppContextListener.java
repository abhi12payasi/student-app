package com.app.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.util.Properties;

public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        servletContextEvent.getServletContext().log(this.getClass()+" contextInitialized");

        ServletContext servletContext = servletContextEvent.getServletContext();
        String propertyFilePath = servletContext.getInitParameter("propertyFilePath");

        try{
            FileReader fileReader = new FileReader(new File(propertyFilePath));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data = "",s ;
            Properties propertiesObj = new Properties();
            while ( (s = bufferedReader.readLine())!=null ){
                String p[] = s.split("=");
                propertiesObj.setProperty(p[0] , p[1]);
                data = data + s;
            }
            servletContext.setAttribute("propertiesObj" , propertiesObj);
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Destroyed!!");
        servletContextEvent.getServletContext().log(this.getClass()+" contextDestroyed");
    }
}
