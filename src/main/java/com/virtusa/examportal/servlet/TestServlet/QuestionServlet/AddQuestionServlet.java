package com.virtusa.examportal.servlet.TestServlet.QuestionServlet;

import com.virtusa.examportal.dao.QuestionDAO;
import com.virtusa.examportal.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddQuestionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int testId = Integer.parseInt(req.getParameter("testId"));
        String questionText = req.getParameter("questionText");
        String option1 = req.getParameter("option1");
        String option2 = req.getParameter("option2");
        String option3 = req.getParameter("option3");
        String option4 = req.getParameter("option4");
        int correctOption = Integer.parseInt(req.getParameter("correctOption"));

        Question question = new Question();
        question.setTestId(testId);
        question.setQuestionText(questionText);
        question.setOption1(option1);
        question.setOption2(option2);
        question.setOption3(option3);
        question.setOption4(option4);
        question.setCorrectOption(correctOption);

        QuestionDAO questionDAO = new QuestionDAO();
        boolean status = questionDAO.addQuestion(question);

        if (status) {
            resp.sendRedirect("questionAdded.jsp");
        } else {
            resp.sendRedirect("addQuestion.jsp?error=true");
        }
    }
}
