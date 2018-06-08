package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConn {
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test_database", "root", "12345678");
        } catch (Exception e) {
// TODO: handle exception
        }


        return connection;
    }
    public void closeConn(Connection connection) {

        try {
            connection.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
