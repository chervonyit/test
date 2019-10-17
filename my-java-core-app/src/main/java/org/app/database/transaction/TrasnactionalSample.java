package org.app.database.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TrasnactionalSample {

    public void makeActions(){
        try(Connection c = getConnection()){

            c.setAutoCommit(false);
            PreparedStatement ps = c.prepareStatement("INSERT INTO myitem(name, age) VALUES(?,?)");
            ps.setObject(1, "Step1");
            ps.setObject(2, 1);
            ps.execute();


            ps = c.prepareStatement("INSERT INTO myitem(name, age) VALUES(?,?)");
            ps.setObject(1, "Step2");
            ps.setObject(2, 2);
            ps.execute();

            c.commit();

        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3307/taras_db", "root", "11111111");
    }
}
