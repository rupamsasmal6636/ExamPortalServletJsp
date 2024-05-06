package com.virtusa.examportal.servlet.TestServlet;

import com.virtusa.examportal.dao.QuestionDAO;
import com.virtusa.examportal.dao.TestDAO;
import com.virtusa.examportal.model.Question;
import com.virtusa.examportal.model.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int testId = Integer.parseInt(req.getParameter("testId"));
        TestDAO testDAO = new TestDAO();
        Test test = testDAO.getTestById(testId);
        if(test!=null){
            QuestionDAO questionDAO = new QuestionDAO();
            List<Question> questions = questionDAO.getQuestionsByTestId(testId);
            req.setAttribute("test",test);
            req.setAttribute("questions",questions);
            req.getRequestDispatcher("viewTest.jsp").forward(req,resp);
        }
        else {
            resp.sendRedirect("error.jsp");
        }
    }
}
