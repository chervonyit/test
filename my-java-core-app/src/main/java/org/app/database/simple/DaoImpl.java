package org.app.database.simple;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoImpl implements Dao {
    private DataSource ds = new MyDataSource();

    /*static {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public void create(MyItem myItem) {
        Connection c = null;
        try {
            c = getConnection();
            Statement statement = c.createStatement();
            String sql = String.format("INSERT INTO myitem(name, age) VALUES('%s', %s)", myItem.getName(), myItem.getAge());
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public List<MyItem> read() {
        List<MyItem> list = new ArrayList();
        try (Connection c = getConnection()) {
            Statement statement = c.createStatement();
            String sql = "SELECT * FROM myitem";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                MyItem myItem = new MyItem();
                myItem.setAge(age);
                myItem.setName(name);
                list.add(myItem);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(MyItem currentMyItem, MyItem candidate) {
        try (Connection c = getConnection()) {
            String sql = "UPDATE myitem SET name=?,age=? where name in(?) AND age=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(4, currentMyItem.getAge());
            ps.setObject(1, candidate.getName());
            ps.setInt(2, candidate.getAge());
            ps.setString(3, currentMyItem.getName());
            ps.execute();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    //public abstract void update(Connection c, MyItem currentMyItem, MyItem candidate);

    @Override
    public void delete(MyItem myItem) {
        try (Connection c = getConnection()) {
            c.prepareStatement("DELETE FROM myitem WHERE age=" + myItem.getAge()).execute();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Map<String, Object>> meatInf() {

        try (Connection c = getConnection()) {
            Statement statement = c.createStatement();
            String sql = "SELECT * FROM myitem";
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            int n = metaData.getColumnCount();
            List<String> columnNames = new ArrayList<>();
            for(int i=0;i<n;i++){
                columnNames.add(metaData.getColumnName(i+1));
            }

            List<Map<String, Object>> list = new ArrayList<>();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                list.add(map);

                for(String columnName: columnNames){
                    Object value=rs.getObject(columnName);
                    map.put(columnName, value);
                }

            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private Connection getConnection() throws SQLException {
    //    return DriverManager.getConnection("jdbc:mysql://localhost:3307/taras_db", "root", "11111111");
        return ds.getConnection();
    }
}
