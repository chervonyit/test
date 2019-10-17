package com.app03.dispatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "MyFasadeFilter", urlPatterns = {"/myServletA","/myServletB", "/serverFasade"})
public class MyFasadeFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("@Before");
        chain.doFilter(req, resp);
        System.out.println("@After");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
