package com.virtusa.examportal.dao;

import com.virtusa.examportal.model.User;
import com.virtusa.examportal.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public User authenticateUser(String username, String password){
        User user=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        try{
            connection= DBUtil.getConnection();
            String query="SELECT * FROM users WHERE username = ? AND password = ?";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            rs=preparedStatement.executeQuery();
            if(rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setUsername(username);
                user.setPassword(password);
                user.setName(rs.getString("name"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection,preparedStatement,rs);
        }
        return user;
    }

    public boolean createUser(User user){
        boolean status = false;
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String query = "INSERT INTO users (username, password, role, name) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getRole());
            preparedStatement.setString(4,user.getName());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0) status = true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection,preparedStatement);
        }
        return  status;
    }
    public boolean deleteUser(int userId){
        boolean status = false;
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String query = "DELETE FROM users WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,userId);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0) status = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection,preparedStatement);
        }
        return  status;
    }
    public User getUserByUsername(String username) {
        User user = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String query = "SELECT * FROM users WHERE username = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, stmt, rs);
        }
        return user;
    }
}
