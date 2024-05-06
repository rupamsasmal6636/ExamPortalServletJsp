package com.virtusa.examportal.dao;

import com.virtusa.examportal.model.Test;
import com.virtusa.examportal.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
    public boolean createTest(Test test){
        boolean status = false;
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String query = "INSERT INTO tests (title, duration, creator_id) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,test.getTitle());
            preparedStatement.setInt(2,test.getDuration());
            preparedStatement.setInt(3,test.getCreatorId());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0) status = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection,preparedStatement);
        }
        return  status;
    }
    public boolean updateTest(Test test) {
        boolean status = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtil.getConnection();
            String query = "UPDATE tests SET title = ?, duration = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, test.getTitle());
            preparedStatement.setInt(2, test.getDuration());
            preparedStatement.setInt(3, test.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection, preparedStatement);
        }
        return status;
    }
    public boolean deleteTest(int testId) {
        boolean status = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtil.getConnection();
            String query = "DELETE FROM tests WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, testId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection, preparedStatement);
        }
        return status;
    }
    public List<Test> getTestsByCreatorId(int creatorId){
        List<Test> tests = new ArrayList<>();
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            String query = "SELECT * FROM tests WHERE creator_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, creatorId);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                Test test = new Test();
                test.setId(rs.getInt("id"));
                test.setTitle(rs.getString("title"));
                test.setDuration(rs.getInt("duration"));
                test.setCreatorId(rs.getInt("creator_id"));
                tests.add(test);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection,preparedStatement,rs);
        }
        return  tests;
    }
    public Test getTestById(int testId) {
        Test test = null;
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            String query = "SELECT * FROM tests WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, testId);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                test = new Test();
                test.setId(rs.getInt("id"));
                test.setTitle(rs.getString("title"));
                test.setDuration(rs.getInt("duration"));
                test.setCreatorId(rs.getInt("creator_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection,preparedStatement,rs);
        }
        return test;
    }
    public List<Test> getAllTests(){
        List<Test> tests = new ArrayList<>();
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            String query = "SELECT * FROM tests";
            preparedStatement = connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                Test test = new Test();
                test.setId(rs.getInt("id"));
                test.setTitle(rs.getString("title"));
                test.setDuration(rs.getInt("duration"));
                test.setCreatorId(rs.getInt("creator_id"));
                tests.add(test);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection,preparedStatement,rs);
        }
        return  tests;
    }
}
