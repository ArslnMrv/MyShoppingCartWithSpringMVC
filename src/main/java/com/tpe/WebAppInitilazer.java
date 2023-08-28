package com.tpe;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Dispatcher Servlet in configure edilmesi ve başlatılmasını sağlayacak
public class WebAppInitilazer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*
    Dispatcher Servlet bileşenleri
      #Root MVCContext --> Db ile ilgili bileşenler Hibernate,JDBC
      #Servlet MVCContext -->Controller, ViewRoselver, HandlerMapping
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ RootContexConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ WebMvcConfig.class };
    }

    @Override   //Dispatcher Servlet in karşılayacağı endpointler
    protected String[] getServletMappings() {
        return new String[]{ "/" };
    }
}
