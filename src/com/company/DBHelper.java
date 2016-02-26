package com.company;

import java.sql.*;

public class DBHelper {

    public Connection getConnection() {

        String dbURL = "jdbc:mysql://localhost/JavaII";
        String username = "javaII";
        String password = "javaII";

        try {

            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                return conn;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
