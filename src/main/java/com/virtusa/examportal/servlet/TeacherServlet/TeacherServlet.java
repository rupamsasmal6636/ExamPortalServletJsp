package com.virtusa.examportal.servlet.TeacherServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = null;
        action = req.getParameter("page");

        switch (action) {
            case "dashboard":
                String username = (String) req.getSession().getAttribute("user");
                if (username == null) {
                    resp.sendRedirect("loginController?action=login");
                } else {
                    System.out.println("teacher's email: " + username);
                    // resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                    // req.getRequestDispatcher("/views/teacher/teacherDashboard.jsp").forward(req, resp);
                }
                break;
            case "createTest":
                
                break;
            case "assignTest":
                break;
            case "viewResults":
                break;
            default:
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }

}
