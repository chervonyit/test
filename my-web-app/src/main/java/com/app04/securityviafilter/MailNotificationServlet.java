package com.app04.securityviafilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "mailNotificationServlet", urlPatterns = {"/mailNotificationServlet"})
public class MailNotificationServlet extends HttpServlet {
    //MyMailSender myMailSender = new MyMailSender();

    //private MyMailSender myMailSender;

    public void init(){
      //  myMailSender = new MyMailSender();
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //MyMailSender myMailSender = new MyMailSender();
        //myMailSender.sendMail();

        ServletContext ctx = getServletContext();
        MyMailSender myMailSender = (MyMailSender) ctx.getAttribute("mailSender");

        /*HttpSession session = null;
        session.getAttribute("");
        session.setAttribute("a", null);*/

    }
}
