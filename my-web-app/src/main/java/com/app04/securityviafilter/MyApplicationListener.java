package com.app04.securityviafilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class MyApplicationListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public MyApplicationListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("------------Global INIT--------------");
        ServletContext context = sce.getServletContext();
        context.setAttribute("mailSender", new MyMailSender());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("------------Global destory--------------");
    }

}
