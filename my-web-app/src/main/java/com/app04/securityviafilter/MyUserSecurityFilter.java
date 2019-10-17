package com.app04.securityviafilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.LogRecord;

@WebFilter(filterName = "myUserSecurityFilter", urlPatterns = {"/myUserPage"})
public class MyUserSecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);
        if(session==null){
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if(username!=null && password!=null) {
                if (checkUser(username, password)) {
                    session = request.getSession(true);
                    session.setAttribute("username", username);
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/loginServlet");
                requestDispatcher.forward(servletRequest, servletResponse);
            }
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private boolean checkUser(String username, String password){
        return true;
    }

    @Override
    public void destroy() {

    }
}
