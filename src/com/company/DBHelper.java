package com.company;

import java.sql.*;

class DBHelper {
    private final UI ui = new UI();

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
            ui.print("Can't connect to database\n");
        }
        return null;
    }
}
