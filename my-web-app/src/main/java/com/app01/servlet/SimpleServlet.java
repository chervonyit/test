package com.app01.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "simpleServlet", urlPatterns = "/simpleServlet")
public class SimpleServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Simple");
        String nameValue=req.getParameter("name");
        String ageValue=req.getParameter("age");
        int age = Integer.parseInt(ageValue);
        String str=String.format("name=%s; age=%s", nameValue, age);
//        InputStream in = req.getInputStream();
//        Reader reader = req.getReader();

        /*try(OutputStream out = resp.getOutputStream()){
            out.write(str.getBytes());
        }*/

        try(PrintWriter writer = resp.getWriter()){
            writer.println(str);
        }
    }
}
