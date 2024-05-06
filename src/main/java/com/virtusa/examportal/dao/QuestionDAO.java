package com.virtusa.examportal.dao;

import com.virtusa.examportal.model.Question;
import com.virtusa.examportal.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
    public boolean addQuestion(Question question) {
        boolean status = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String query = "INSERT INTO questions (test_id, question_text, option1, option2, option3, option4, correct_option) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, question.getTestId());
            preparedStatement.setString(2, question.getQuestionText());
            preparedStatement.setString(3, question.getOption1());
            preparedStatement.setString(4, question.getOption2());
            preparedStatement.setString(5, question.getOption3());
            preparedStatement.setString(6, question.getOption4());
            preparedStatement.setInt(7, question.getCorrectOption());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            DBUtil.closeConnection(connection, preparedStatement);
        }
        return status;
    }
    public List<Question> getQuestionsByTestId(int testId) {
        List<Question> questions = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            String query = "SELECT * FROM questions WHERE test_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, testId);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setTestId(rs.getInt("test_id"));
                question.setQuestionText(rs.getString("question_text"));
                question.setOption1(rs.getString("option1"));
                question.setOption2(rs.getString("option2"));
                question.setOption3(rs.getString("option3"));
                question.setOption4(rs.getString("option4"));
                question.setCorrectOption(rs.getInt("correct_option"));
                questions.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection, preparedStatement, rs);
        }
        return questions;
    }
    public boolean updateQuestion(Question question) {
        boolean status = false;
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = DBUtil.getConnection();
            String query = "UPDATE questions SET question_text = ?, option1 = ?, option2 = ?, option3 = ?, option4 = ?, correct_option = ? WHERE id = ?";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, question.getQuestionText());
            stmt.setString(2, question.getOption1());
            stmt.setString(3, question.getOption2());
            stmt.setString(4, question.getOption3());
            stmt.setString(5, question.getOption4());
            stmt.setInt(6, question.getCorrectOption());
            stmt.setInt(7, question.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection, stmt);
        }
        return status;
    }

    // Method to delete a question by its ID
    public boolean deleteQuestion(int questionId) {
        boolean status = false;
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = DBUtil.getConnection();
            String query = "DELETE FROM questions WHERE id = ?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, questionId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection, stmt);
        }
        return status;
    }
}
