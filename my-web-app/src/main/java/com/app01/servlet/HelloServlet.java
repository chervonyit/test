package com.app01.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", urlPatterns = {"/helloServlet", "/helloServlet2"})
public class HelloServlet extends HttpServlet {

    static {
        System.out.println("Static1");
    }

    {
        System.out.println("\tinit1");
    }

    {
        System.out.println("\tinit2");
    }

    public HelloServlet() {
        System.out.println("\t\tConstructor");
    }

    @Override
    public void init(){
        System.out.println("\t\t\tinit()");
    }

    public void service(HttpServletRequest request, HttpServletResponse servletResponse) {
        System.out.println("Here!!!");
    }

    @Override
    public void destroy(){
        System.out.println("\t\t\tdestroy()");
    }

    static {
        System.out.println("Static2");
    }

}
