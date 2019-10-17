package com.app04.securityviafilter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        String s ="<HTML><BODY>"+

                "<form method='get' action='myUserPage'>" +
                "<input type='text' name='username'/>" +
                "<input type='password' name='password'/>"+
                "<input type='submit'/>"+
                "</form></BODY></HTML>";
        resp.getWriter().println(s);
    }
}
