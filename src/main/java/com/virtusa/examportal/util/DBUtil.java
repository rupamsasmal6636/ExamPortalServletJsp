package com.virtusa.examportal.util;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {
//    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/examportal";
//    private static final String DB_USERNAME = "root";
//    private static final String DB_PASSWORD = "root";

    public static Connection getConnection() throws SQLException{
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(resourceBundle.getString("DB_URL"),resourceBundle.getString("USER"),resourceBundle.getString("PASSWORD"));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Failed to connect to the database.");
        }
        return connection;
    }
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void closeConnection(Connection conn, PreparedStatement stmt) {
        closeConnection(conn);
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {
        closeConnection(conn, stmt);
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
