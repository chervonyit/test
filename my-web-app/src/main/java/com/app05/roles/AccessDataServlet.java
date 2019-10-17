package com.app05.roles;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class AccessDataServlet extends HttpServlet {

    @Resource(name = "myDS")
    private DataSource ds;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection c = ds.getConnection()){
            resp.getWriter().append(ds+"");
        } catch (SQLException e) {
           // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
