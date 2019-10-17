package com.app03.dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "serverFacade", urlPatterns = "/serverFasade")
public class ServerFasade extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if("a".equalsIgnoreCase(name)){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myServletA");
            requestDispatcher.forward(req, resp);
            System.out.println("After forward A");
            resp.getWriter().println("After forward A");
        }else if("b".equalsIgnoreCase(name)){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myServletB");
            requestDispatcher.include(req, resp);
            System.out.println("After include B");
            resp.getWriter().println("After include B");
        }
    }
}
