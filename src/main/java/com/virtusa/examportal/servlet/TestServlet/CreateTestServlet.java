package com.virtusa.examportal.servlet.TestServlet;

import com.virtusa.examportal.dao.TestDAO;
import com.virtusa.examportal.model.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createTest")
public class CreateTestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title=req.getParameter("title");
        int duration = Integer.parseInt(req.getParameter("duration"));
        int creatorId = Integer.parseInt(req.getParameter("creatorId"));

        Test test = new Test();
        test.setTitle(title);
        test.setDuration(duration);
        test.setCreatorId(creatorId);

        TestDAO testDAO=new TestDAO();
        boolean status = testDAO.createTest(test);
        if(status){
            resp.sendRedirect("testCreated.jsp");
        } else{
            resp.sendRedirect("createTest.jsp?error=true");
        }
    }
}
